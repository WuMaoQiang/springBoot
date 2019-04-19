package com.cc.demo.lesson2_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class loginController {
    @PostMapping(value = "user/login")
    public String login(@RequestParam(value = "name") String name, @RequestParam(value = "pass") String pass, Map<String, String> map) {

        if (!StringUtils.isEmpty(name) && "123".equals(pass)) {
            map.put("name", name);
            map.put("pass",pass);
            return "dashboard";

        } else {
            map.put("errorMessage", "用户名或密码错误");
            return "index";

        }

    }
}
