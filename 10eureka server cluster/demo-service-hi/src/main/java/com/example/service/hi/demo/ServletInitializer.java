package com.example.service.hi.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * <p>
 * <code>ServletInitializer</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/3/22 14:46
 */
public class ServletInitializer extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
}
