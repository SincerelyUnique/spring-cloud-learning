/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.service.ribbon.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * <code>HelloService</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/3/21 8:31
 */
@Service
public class HelloService {

    RestTemplate restTemplate;

    @Autowired
    public HelloService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public String hiService(String name){
        //注意这里的url是即将调用的服务名字，访问这个服务时，采用负载均衡在两个client之间调用
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
}
