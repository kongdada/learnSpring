package com.kaka.service.shard;

import com.google.code.shardbatis.builder.ShardConfigHolder;
import com.google.code.shardbatis.builder.ShardConfigParser;
import com.google.code.shardbatis.converter.SqlConverterFactory;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import com.google.code.shardbatis.util.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author konglinghui01
 * @date 2020/6/22 15:56
 */
@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}
)})
public class ShardPlugin implements Interceptor {
    private static final Log log = LogFactory.getLog(com.kaka.service.shard.ShardPlugin.class);
    public static final String SHARDING_CONFIG = "shardingConfig";
    private static final ConcurrentHashMap<String, Boolean> SHARDING_CACHE = new ConcurrentHashMap();

    public ShardPlugin() {
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MappedStatement mappedStatement = null;
        if (statementHandler instanceof RoutingStatementHandler) {
            StatementHandler delegate = (StatementHandler) ReflectionUtils.getFieldValue(statementHandler, "delegate");
            mappedStatement = (MappedStatement) ReflectionUtils.getFieldValue(delegate, "mappedStatement");
        } else {
            mappedStatement = (MappedStatement) ReflectionUtils.getFieldValue(statementHandler, "mappedStatement");
        }

        String mapperId = mappedStatement.getId();
        if (this.isShouldParse(mapperId)) {
            String sql = statementHandler.getBoundSql().getSql();
            if (log.isDebugEnabled()) {
                log.debug("Original Sql [" + mapperId + "]:" + sql);
            }

            Object params = statementHandler.getBoundSql().getParameterObject();
            SqlConverterFactory cf = SqlConverterFactory.getInstance();
            sql = cf.convert(sql, params, mapperId);
            if (log.isDebugEnabled()) {
                log.debug("Converted Sql [" + mapperId + "]:" + sql);
            }

            ReflectionUtils.setFieldValue(statementHandler.getBoundSql(), "sql", sql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String config = properties.getProperty("shardingConfig", (String) null);
        if (config != null && config.trim().length() != 0) {
            ShardConfigParser parser = new ShardConfigParser();
            InputStream input = null;

            try {
                input = Resources.getResourceAsStream(config);
                parser.parse(input);
            } catch (IOException var14) {
                log.error("Get sharding config file failed.", var14);
                throw new IllegalArgumentException(var14);
            } catch (Exception var15) {
                log.error("Parse sharding config file failed.", var15);
                throw new IllegalArgumentException(var15);
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException var13) {
                        log.error(var13.getMessage(), var13);
                    }
                }

            }

        } else {
            throw new IllegalArgumentException("property 'shardingConfig' is requested.");
        }
    }

    private boolean isShouldParse(String mapperId) {
        Boolean parse = (Boolean) SHARDING_CACHE.get(mapperId);
        if (parse != null) {
            return parse;
        } else {
            if (!mapperId.endsWith("!selectKey")) {
                ShardConfigHolder configHolder = ShardConfigHolder.getInstance();
                if (!configHolder.isIgnoreId(mapperId) && (!configHolder.isConfigParseId() || configHolder.isParseId(mapperId))) {
                    parse = true;
                }
            }

            if (parse == null) {
                parse = false;
            }

            SHARDING_CACHE.put(mapperId, parse);
            return parse;
        }
    }
}

