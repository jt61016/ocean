package com.jt61016.ocean.springboot.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author jiangtao
 * @date 2019-12-03 15:36.
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan(value = {"com.jt61016.ocean.springboot"})
//@ImportResource(locations = {"classpath:spring/*.xml"})
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringBootApplication.class);
        application.run(args);
    }
}
