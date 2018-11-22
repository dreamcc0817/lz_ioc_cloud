package com.bonc.dev.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.dev.controller
 * @Description:
 * @Author: dreamcc
 * @Date: 2018/11/13 16:39
 * @Version: V1.0
 */
@RestController
@RequestMapping("/analysis")
public class AnalysisController {

	@PostMapping("/dataChange")
	public String getDeviceDataChange(){
		System.out.println("##################################################################################");
		System.out.println("##################################################################################");
		System.out.println("##################################################################################");
		System.out.println("##################################################################################");
		System.out.println("##################################################################################");
		System.out.println("##################################################################################");
		System.out.println("##################################################################################");
		System.out.println("##################################################################################");
		System.out.println("##################################################################################");

		return "#";
	}
}
