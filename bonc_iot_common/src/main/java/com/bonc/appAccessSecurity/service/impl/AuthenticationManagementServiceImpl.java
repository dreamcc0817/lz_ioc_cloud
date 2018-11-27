package com.bonc.appAccessSecurity.service.impl;

import com.bonc.appAccessSecurity.service.AuthenticationManagementService;
import com.bonc.utils.HttpsUtil;
import com.bonc.utils.JsonUtil;
import com.bonc.utils.StreamClosedHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.appAccessSecurity.service.impl
 * @Description: 鉴权管理
 * @Author: dreamcc
 * @Date: 2018-11-07 09:35
 * @Version: V1.0
 */
@Slf4j
@Service("authentication")
public class AuthenticationManagementServiceImpl implements AuthenticationManagementService {
	@Override
	public void authentication(HttpsUtil httpsUtil, String loginUrl, Map<String, String> loginInfo) throws Exception {
		String accessToken = createToken(httpsUtil, loginUrl, loginInfo);
		//RedisUtil.getJedis().set("accessToken", accessToken);
	}

	@Override
	public void refreshToken(HttpsUtil httpsUtil, String loginUrl, String urlRefreshToken, Map<String, String> loginInfo) throws Exception {
		String jsonRequest = JsonUtil.jsonObj2Sting(loginInfo);
		String refreshToken = createToken(httpsUtil, loginUrl, loginInfo);

		loginInfo.put("refreshToken", refreshToken);

		StreamClosedHttpResponse bodyRefreshToken = httpsUtil.doPostJsonGetStatusLine(urlRefreshToken, jsonRequest);

		log.info("RefreshToken, response content:");
		log.info(bodyRefreshToken.getStatusLine() + "");
		log.info(bodyRefreshToken.getContent());
	}

	public String createToken(HttpsUtil httpsUtil, String loginUrl, Map<String, String> loginInfo) throws Exception{
		StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(loginUrl, loginInfo);

		log.info("app auth success,return accessToken:" + responseLogin.getStatusLine());
		log.info(responseLogin.getContent());

		Map<String, String> data = new HashMap<>();
		data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
		String accessToken = data.get("accessToken");

		return accessToken;
	}
}
