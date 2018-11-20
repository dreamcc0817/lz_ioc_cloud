package com.bonc.dev;

import com.bonc.utils.Constant;
import com.bonc.utils.HttpsUtil;
import com.bonc.utils.JsonUtil;
import com.bonc.utils.StreamClosedHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.dev
 * @Description: 鉴权认证，订阅消息
 * @Author: dreamcc
 * @Date: 2018-11-08 09:09
 * @Version: V1.0
 */
@Slf4j
@RestController
@RequestMapping("/dev")
public class AuthenticationSubscribtion {

	@GetMapping("/start")
	public void authenticationSubscribtion() throws Exception{

		// Two-Way Authentication
		HttpsUtil httpsUtil = new HttpsUtil();
		httpsUtil.initSSLConfigForTwoWay();
		// Authentication，get token
		String accessToken = login(httpsUtil);

		//Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;
		String urlSubscribeServiceNotification = Constant.SUBSCRIBE_SERVICE_NOTIFYCATION;

		String callbackurl_deviceDataChanged = Constant.DEVICE_DATA_CHANGED_CALLBACK_URL;
		String notifyType_deviceDataChanged = Constant.DEVICE_DATA_CHANGED;

		Map<String, Object> paramSubscribe_deviceDataChanged = new HashMap<>();
		paramSubscribe_deviceDataChanged.put("notifyType", notifyType_deviceDataChanged);
		paramSubscribe_deviceDataChanged.put("callbackUrl", callbackurl_deviceDataChanged);
		paramSubscribe_deviceDataChanged.put("appId","zOfrnnJLUYqcrEdvaU7EChYK5HYa");
		String jsonRequest_deviceDataChanged = JsonUtil.jsonObj2Sting(paramSubscribe_deviceDataChanged);

		Map<String, String> header_deviceDataChanged = new HashMap<>();
		header_deviceDataChanged.put(Constant.HEADER_APP_KEY, appId);
		header_deviceDataChanged.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);


		HttpResponse httpResponse_deviceDataChanged = httpsUtil.doPostJson(urlSubscribeServiceNotification, header_deviceDataChanged, jsonRequest_deviceDataChanged);
		String bodySubscribe_deviceDataChanged = httpsUtil.getHttpResponseBody(httpResponse_deviceDataChanged);

		log.info("SubscribeServiceNotification: " + notifyType_deviceDataChanged + ", response content:");
		log.info(httpResponse_deviceDataChanged.getStatusLine()+"");
		log.info(bodySubscribe_deviceDataChanged);

	}

	/**
	 * Authentication，get token
	 */
	@SuppressWarnings("unchecked")
	public static String login(HttpsUtil httpsUtil) throws Exception {

		String appId = Constant.APPID;
		String secret = Constant.SECRET;
		String urlLogin = Constant.APP_AUTH;

		Map<String, String> paramLogin = new HashMap<>();
		paramLogin.put("appId", appId);
		paramLogin.put("secret", secret);

		StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);

		log.info("app auth success,return accessToken:");
		log.info(responseLogin.getStatusLine()+"");
		log.info(responseLogin.getContent());

		Map<String, String> data = new HashMap<>();
		data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
		return data.get("accessToken");
	}
}
