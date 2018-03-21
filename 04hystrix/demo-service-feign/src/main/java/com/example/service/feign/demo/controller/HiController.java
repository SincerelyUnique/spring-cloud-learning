package com.example.service.feign.demo.controller;

import com.example.service.feign.demo.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <code>HiController</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/3/21 9:32
 */
@RestController
public class HiController {

    private SchedualServiceHi schedualServiceHi;

    @Autowired
    public HiController(SchedualServiceHi schedualServiceHi){
        this.schedualServiceHi = schedualServiceHi;
    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
