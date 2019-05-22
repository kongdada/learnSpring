package com.water.MulitDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.water.kaka.mapper", sqlSessionFactoryRef = "kakaSqlSessionFactory")
public class DataSourceKakaConfig {

    /**
     * @methodDesc: 功能描述:(配置test1数据库)
     */
    @Bean(name = "kakaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.kaka")
    @Primary
    public DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @methodDesc: 功能描述:(test1 sql会话工厂)
     */
    @Bean(name = "kakaSqlSessionFactory")
    @Primary
    public SqlSessionFactory SqlSessionFactory(@Qualifier("kakaDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(
        // new
        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
        return bean.getObject();
    }

    /**
     * @methodDesc: 功能描述:(test1 事物管理)
     */
    @Bean(name = "kakaTransactionManager")
    @Primary
    public DataSourceTransactionManager TransactionManager(@Qualifier("kakaDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "kakaSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate SqlSessionTemplate(
            @Qualifier("kakaSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "kakaJdbcTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate(@Qualifier("kakaDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

