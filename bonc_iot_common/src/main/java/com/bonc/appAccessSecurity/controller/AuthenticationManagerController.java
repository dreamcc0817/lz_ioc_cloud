package com.bonc.appAccessSecurity.controller;

import com.bonc.appAccessSecurity.service.AuthenticationManagementService;
import com.bonc.utils.Constant;
import com.bonc.utils.HttpsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.appAccessSecurity
 * @Description:
 * @Author: dreamcc
 * @Date: 2018-11-06 11:52
 * @Version: V1.0
 */

@RestController
@RequestMapping("/appAccessSecurity")
public class AuthenticationManagerController {

	private AuthenticationManagementService authenticationManagementService;
	private static HttpsUtil httpsUtil;

	static {
		try {
			httpsUtil = new HttpsUtil();
			httpsUtil.initSSLConfigForTwoWay();
		} catch (Exception e) {
		}
	}

	@Autowired
	public AuthenticationManagerController(AuthenticationManagementService authenticationManagementService) {
		this.authenticationManagementService = authenticationManagementService;
	}

	@GetMapping("/authentication")
	public String authentication() throws Exception{
		String appId = Constant.APPID;
		String secret = Constant.SECRET;
		String urlLogin = Constant.APP_AUTH;
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("appId", appId);
		loginInfo.put("secret", secret);
		authenticationManagementService.authentication(httpsUtil,urlLogin,loginInfo);
		return "SUCCESS";
	}

	@GetMapping("/refresh")
	public String refreshToken() throws Exception{
		String refreshToken = "";
		String appId = Constant.APPID;
		String secret = Constant.SECRET;
		String urlLogin = Constant.APP_AUTH;
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("appId", appId);
		loginInfo.put("secret", secret);
		authenticationManagementService.refreshToken(httpsUtil,urlLogin,refreshToken,loginInfo);
		return "SUCCESS";
	}
}
