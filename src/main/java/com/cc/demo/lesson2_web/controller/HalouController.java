package com.cc.demo.lesson2_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HalouController {

    //只有写成Controller 才会返回html页面
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        Bean bean1 = new Bean();
        bean1.setName("name");
        bean1.setSex("nan");
        Bean bean2 = new Bean();
        bean2.setSex("nv");
        bean2.setName("meinv");
        map.put("hello", "你好");
        map.put("prods", Arrays.asList(bean1, bean2));
        return "success";
    }

    private class Bean {
        private String name;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
