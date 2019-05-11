package com.water.kaka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class FTLController {
    @RequestMapping("/ftlIndex")
    public String ftlIndex(Map<String, Object> result) {
        result.put("name", "kkk");
        result.put("sex", "0");
        List<String> listResult = new ArrayList<String>();
        listResult.add("zhangsan");
        listResult.add("lisi");
        listResult.add("itmayiedu");
        result.put("userlist", listResult);

        return "ftlIndex";
    }
}
