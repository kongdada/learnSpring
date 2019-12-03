package com.water.kaka.controller;

import com.alibaba.fastjson.JSON;
import com.water.model.Demo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: konglinghui
 * @date: 2019/12/2
 */
@RestController
public class TestDemo {
    @RequestMapping("/demo/a")
    public String aDemo(@RequestBody Map<String, Object> map) {
        return JSON.toJSONString(map);
    }

    @RequestMapping("/demo/b")
    public String bDemo(Map<String, Object> map) {
        return JSON.toJSONString(map);
    }

    @RequestMapping("/demo/c")
    public String cDemo(@RequestBody Demo demo) {
        return JSON.toJSONString(demo);
    }

    @RequestMapping("/demo/d")
    public String dDemo(Demo demo) {
        return JSON.toJSONString(demo);
    }

    @RequestMapping("/demo/e")
    public String eDemo(@RequestBody Long demo) {
        return JSON.toJSONString(demo);
    }

    @RequestMapping("/demo/f")
    public String fDemo(@RequestParam Long demo) {
        return JSON.toJSONString(demo);
    }

    @RequestMapping("/demo/g")
    public String gDemo(Long demo) {
        return JSON.toJSONString(demo);
    }
}
