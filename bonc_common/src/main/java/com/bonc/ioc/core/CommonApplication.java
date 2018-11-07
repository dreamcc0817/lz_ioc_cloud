package com.bonc.ioc.core;/**
 * Created by wo on 2018-09-25.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * CommonApplication模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-25 9:50
 */
@SpringBootApplication
@EnableFeignClients
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }
}
