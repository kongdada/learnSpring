package commTool.http;

import com.alibaba.fastjson.JSONObject;
import commTool.http.callback.HttpCallBack;
import commTool.http.callback.JSONResultCallBack;
import commTool.http.callback.StringCallBack;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {
    private HttpClientUtils() {
    }

    protected static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 发送json数据,响应json数据,可自定义config
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param body
     * @param ctx
     * @param requestConfig
     * @return
     * @throws Exception
     */
    public static JSONObject postJsonReturnJsonWithConfig(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                                          String body, HttpClientContext ctx, RequestConfig requestConfig) throws Exception {
        return doPost(baseUrl, urlParams, headers, null, ctx, JSONResultCallBack.INSTANCE, requestConfig, true, body);
    }

    /**
     * post方法，返回json
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param params
     * @param ctx
     * @param requestConfig
     * @return
     * @throws Exception
     */
    public static JSONObject postReturnJsonWithConfig(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                                      Map<String, String> params, HttpClientContext ctx, RequestConfig requestConfig) throws Exception {
        return doPost(baseUrl, urlParams, headers, params, ctx, JSONResultCallBack.INSTANCE, requestConfig, false, null);
    }

    /**
     * post方法，返回json
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param params
     * @param ctx
     * @return
     * @throws Exception
     */
    public static JSONObject postReturnJsonNoConfig(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                                    Map<String, String> params, HttpClientContext ctx) throws Exception {
        return doPost(baseUrl, urlParams, headers, params, ctx, JSONResultCallBack.INSTANCE, null, false, null);
    }

    /**
     * post方法，返回String
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param params
     * @param ctx
     * @return
     * @throws Exception
     */
    public static String postReturnStringNoConfig(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                                  Map<String, String> params, HttpClientContext ctx) throws Exception {
        return doPost(baseUrl, urlParams, headers, params, ctx, StringCallBack.INSTANCE, null, false, null);
    }

    /**
     * 发送post请求，json格式的body，编码格式utf-8
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param body
     * @param ctx
     * @param callBack
     * @return
     * @throws Exception
     */
    public static <T> T postJsonNoConfig(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                         String body, HttpClientContext ctx, HttpCallBack<T> callBack) throws Exception {
        return doPost(baseUrl, urlParams, headers, null, ctx, callBack, null, true, body);
    }

    /**
     * 发送post请求，json格式的body，编码格式utf-8
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param body
     * @param ctx
     * @param callBack
     * @param requestConfig 可以用于设置超时时间等
     * @return
     * @throws Exception
     */
    public static <T> T postJsonWithConfig(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                           String body, HttpClientContext ctx, HttpCallBack<T> callBack,
                                           RequestConfig requestConfig) throws Exception {

        return doPost(baseUrl, urlParams, headers, null, ctx, callBack, requestConfig, true, body);
    }

    /**
     * get方法，返回字符串
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param ctx
     * @return
     * @throws Exception
     */
    public static String getReturnString(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                         HttpClientContext ctx, RequestConfig requestConfig) throws Exception {
        return doGet(baseUrl, urlParams, headers, ctx, StringCallBack.INSTANCE, requestConfig);
    }

    /**
     * get方法，返回json
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param ctx
     * @return
     * @throws Exception
     */
    public static JSONObject getReturnJson(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                           HttpClientContext ctx, RequestConfig requestConfig) throws Exception {
        return doGet(baseUrl, urlParams, headers, ctx, JSONResultCallBack.INSTANCE, requestConfig);
    }

    public static <T> T get(String url) {
        RequestConfig cfg = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setSocketTimeout(5000).build();
        T result = null;
        try {
            result = HttpClientUtils.doGet(url, null,
                    null, null, (HttpCallBack<T>) StringCallBack.INSTANCE, cfg);
        } catch (Exception e) {
            logger.error("url :{},请求失败", url);
        }
        return result;
    }

    /**
     * 基础get方法
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param ctx
     * @param callBack
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T doGet(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                              HttpClientContext ctx, HttpCallBack<T> callBack, RequestConfig requestConfig) throws Exception {

        String url = combineUrlParam(baseUrl, urlParams);
        HttpGet get = new HttpGet(url);

        T resp = null;
        try {
            if (headers != null) {
                Iterator<String> it = headers.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    String value = headers.get(key);
                    get.addHeader(key, value);
                }
            }
            CloseableHttpClient httpClient = createClient(baseUrl.startsWith("https"));
            if (null != requestConfig) {
                get.setConfig(requestConfig);
            }
            HttpResponse response = httpClient.execute(get, ctx);
            resp = callBack.resolve(response);
        } finally {
            get.releaseConnection();
        }
        return resp;
    }

    /**
     * 基础post方法
     *
     * @param baseUrl
     * @param urlParams
     * @param headers
     * @param params
     * @param ctx
     * @param callBack
     * @param <T>
     * @return
     * @throws Exception
     */
    private static <T> T doPost(String baseUrl, Map<String, String> urlParams, Map<String, String> headers,
                                Map<String, String> params, HttpClientContext ctx,
                                HttpCallBack<T> callBack, RequestConfig requestConfig, boolean bodyJson, String body) throws Exception {

        String url = combineUrlParam(baseUrl, urlParams);
        HttpPost post = new HttpPost(url);

        T resp = null;
        try {
            if (headers != null) {
                Iterator<String> it = headers.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    String value = headers.get(key);
                    post.addHeader(key, value);
                }
            }

            //url encoded param
            List<NameValuePair> pairs = new ArrayList<>();
            if (params != null) {
                Iterator<String> it = params.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    String value = params.get(key);
                    NameValuePair np = new BasicNameValuePair(key, value);
                    pairs.add(np);
                }
                post.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
            }

            if (StringUtils.isNotBlank(body) && bodyJson) {
                HttpEntity entity = EntityBuilder.create().setText(body)
                        .setContentType(ContentType.APPLICATION_JSON).setContentEncoding("UTF-8").build();
                post.setEntity(entity);
            }


            CloseableHttpClient httpClient = createClient(baseUrl.startsWith("https"));
            if (null != requestConfig) {
                post.setConfig(requestConfig);
            }
            HttpResponse response = httpClient.execute(post, ctx);
            resp = callBack.resolve(response);

        } finally {
            post.releaseConnection();
        }

        return resp;
    }

    private static String combineUrlParam(String baseUrl, Map<String, String> urlParams) throws Exception {
        String url = "";
        if (urlParams != null) {
            Iterator<String> it = urlParams.keySet().iterator();
            StringBuilder paramStrBuilder = new StringBuilder("");
            while (it.hasNext()) {
                String key = it.next();
                String value = urlParams.get(key);
                paramStrBuilder.append(key).append("=").append(URLEncoder.encode(value, "UTF-8")).append("&");
            }
            paramStrBuilder.setLength(paramStrBuilder.length() - 1);
            String paramStr = paramStrBuilder.toString();
            if (StringUtils.isNotBlank(paramStr)) {
                url = StringUtils.chomp(baseUrl, "/") + "?" + paramStr;
            }
        } else {
            url = baseUrl;
        }

        return url;
    }

    private static CloseableHttpClient createClient(boolean isSSL) throws Exception {
        if (isSSL) {
            return SSLClient.getSSLClient();
        }
        return HttpClients.createDefault();
    }
}