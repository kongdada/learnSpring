package commTool;

import com.alibaba.fastjson.JSONObject;
import commTool.http.HttpClientUtils;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: konglinghui
 * @date: 2019/7/26
 */
public class JXLTool {
    private static void wosOnline(String url) throws Exception {

        String filename = url.substring(url.lastIndexOf("/") + 1);
        String expire = String.valueOf(System.currentTimeMillis() / 1000L + 1800L);
        //HttpGet get = new HttpGet("http://token.wos.58dns.org/get_token?bucket=media&filename="+filename+"&expire=" + expire);
        Map<String, String> urlParams = new HashMap<>(3);
        urlParams.put("bucket", "media");
        urlParams.put("filename", filename);
        urlParams.put("expire", expire);

        Map<String, String> headers = new HashMap<>(1);
        // 需要账号密码（注意区分线上和测试环境）
        String authorizationStr = "";
        byte[] bytes = authorizationStr.getBytes(StandardCharsets.UTF_8);
        String encode = new BASE64Encoder().encode(bytes);
        headers.put("Authorization", "Basic " + encode);

        System.out.print("获取 WOS token, 入参 url:" + "http://token.wos.58dns.org/get_token");
        System.out.print("urlParam:" + urlParams);
        System.out.println("headers:" + headers);
        JSONObject returnJson = HttpClientUtils.getReturnJson("http://token.wos.58dns.org/get_token", urlParams, headers, null, null);
        String data = returnJson.getString("data");
        System.out.println(url + "?token=" + data);

    }

    public static void main(String[] args) throws Exception {
        wosOnline("aaa");
    }
}
