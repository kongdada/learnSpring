package commTool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kaka.model.User;

/**
 * @description:
 * @author: konglinghui
 * @date: 2019/6/22
 */
public class JsonToJava {


    public static void main(String[] args) {
        User user = new User("4", "kong", "男");
        JSONObject json = JSON.parseObject(JSON.toJSONString(user));
        String parameter = json.getString("name");

        System.out.println(parameter);
        System.out.println(json.getString("id"));
        System.out.println(json.getString("sex"));
    }
}
