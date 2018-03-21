/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.service.ribbon.demo.controller;

import com.example.service.ribbon.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <code>HelloController</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/3/21 8:34
 */
@RestController
public class HelloController {

    HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }

    @RequestMapping("hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
