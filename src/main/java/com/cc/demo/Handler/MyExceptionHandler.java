package com.cc.demo.Handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String ,Object> handlerException(Exception e){
        Map<String ,Object> map =new HashMap<>();
        map.put("code", "user not exist");
        map.put("message", e.getMessage());
        map.put("aaa", "MyExceptionHandler定制错误页面");
        return map;
    }
}