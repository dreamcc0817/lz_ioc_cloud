package com.bonc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc
 * @Description:
 * @Author: dreamcc
 * @Date: 2018-11-06 14:29
 * @Version: V1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class IotApplication {
	public static void main(String[] args) {
		SpringApplication.run(IotApplication.class, args);
	}
}
