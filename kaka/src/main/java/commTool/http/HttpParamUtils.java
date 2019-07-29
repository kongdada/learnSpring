package commTool.http;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 **/
public class HttpParamUtils {
	private HttpParamUtils() {}
	
    private static Logger logger = LoggerFactory.getLogger(HttpParamUtils.class);

    /**
     * 根据url解析获得参数map
     * @param url url全地址
     * @return k-v map
     */
    public static Map<String, String> getParamsByUrl(String url) {
        try{
            logger.info("url为：{}", url);
            Map<String, String> map = new HashMap<>();
            // 如果url为空，或者字符串中没有？分隔符，直接return
            if (StringUtils.isEmpty(url) || !StringUtils.contains(url, "?")) {
                return null;
            }
            String params = url.split("\\?")[1];
            logger.info("根据问号分割后的参数为：{}",params);
            // 判断截取的参数是否为空，或者是否含有=分隔符，否则直接return
            if (StringUtils.isEmpty(params) || !StringUtils.contains(params, "=")) {
                return null;
            }
            String[] paramArray = params.split("&");
            if (paramArray.length != 0) {
                for (String kv : paramArray) {
                    if(StringUtils.isEmpty(kv) || !StringUtils.contains(kv,"=")) {
                        continue;
                    }
                    map.put(kv.split("=")[0], kv.split("=")[1]);
                }
            }
            return map;
        }catch (Exception ex){
            logger.error("处理url中的参数异常");
            return null;
        }
    }

}
