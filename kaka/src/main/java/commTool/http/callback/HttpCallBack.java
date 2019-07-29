package commTool.http.callback;

import org.apache.http.HttpResponse;

public interface HttpCallBack<T> {
    T resolve(HttpResponse response) throws Exception;
}