package commTool.http.callback;


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class StringCallBack implements HttpCallBack<String> {

    public static StringCallBack INSTANCE = new StringCallBack();

    private StringCallBack() {

    }
    @Override
    public String resolve(HttpResponse response) throws Exception {
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }
}