package com.bonc.appAccessSecurity;

import com.bonc.utils.Constant;
import com.bonc.utils.HttpsUtil;
import com.bonc.utils.JsonUtil;
import com.bonc.utils.StreamClosedHttpResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.appAccessSecurity
 * @Description:
 * @Author: dreamcc
 * @Date: 2018-11-07 08:32
 * @Version: V1.0
 */
public class AuthenticationTest {

	@Test
	public void authentication() throws Exception{
		HttpsUtil httpsUtil = new HttpsUtil();
		httpsUtil.initSSLConfigForTwoWay();

		String appId = Constant.APPID;
		String secret = Constant.SECRET;
		String urlLogin = Constant.APP_AUTH;

		Map<String, String> param = new HashMap<>();
		param.put("appId", appId);
		param.put("secret", secret);

		StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, param);

		System.out.println("app auth success,return accessToken:");
		System.out.println(responseLogin.getStatusLine());
		System.out.println(responseLogin.getContent());
		System.out.println();

		//resolve the value of accessToken from responseLogin.
		Map<String, String> data = new HashMap<>();
		data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
		String accessToken = data.get("accessToken");
		System.out.println("accessToken:" + accessToken);
	}
}