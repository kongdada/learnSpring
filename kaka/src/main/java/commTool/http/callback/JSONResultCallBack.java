package commTool.http.callback;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JSONResultCallBack implements HttpCallBack<JSONObject> {
	
	private Logger logger = LoggerFactory.getLogger(JSONResultCallBack.class);

    public static JSONResultCallBack INSTANCE =  new JSONResultCallBack();

    private JSONResultCallBack() {

    }

    @Override
    public JSONObject resolve(HttpResponse response) throws IOException {
    	String str = EntityUtils.toString(response.getEntity());
    	try {
    		return JSONObject.parseObject(str);
    	} catch (Exception e) {
    		logger.error("JSONResultCallBack|resolve|返回值格式不是json格式|str={}", str, e);
    		throw e;
    	}
    }
}