/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.service.feign.demo.service.impl;

import com.example.service.feign.demo.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <code>SchedualServiceHiHystric</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/3/21 12:15
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
