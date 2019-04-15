package com.cc.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
public class helloController {

    @RequestMapping("/hello")
    public String getHello() {
        return "hello123";

    }
}
