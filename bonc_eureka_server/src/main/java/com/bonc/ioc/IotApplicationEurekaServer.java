package com.bonc.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc
 * @Description:
 * @Author: dreamcc
 * @Date: 2018-11-06 14:29
 * @Version: V1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class IotApplicationEurekaServer {
	public static void main(String[] args) {
		SpringApplication.run(IotApplicationEurekaServer.class);
	}
}
