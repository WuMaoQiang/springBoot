package com.cc.demo.lesson1.hello;

import com.cc.demo.lesson1.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
public class helloController {
    @Autowired
    Person person;
    @RequestMapping("/hello")
    public String getHello() {
        return person.getLastName();

    }
}
