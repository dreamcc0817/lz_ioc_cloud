package com.bonc.subscribtionManagement.controller;

import com.bonc.subscribtionManagement.service.SubscribtionServiceNotificationService;
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
 * @Package: com.bonc.subscribtionManagement.controller
 * @Description:
 * @Author: dreamcc
 * @Date: 2018-11-07 14:04
 * @Version: V1.0
 */
@RestController
@RequestMapping("/subscribtionServiceNotification")
public class SubscribtionServiceNotificationController {

	private SubscribtionServiceNotificationService subscribtionServiceNotificationService;
	private static HttpsUtil httpsUtil;
	String urlSubscribeServiceNotification = Constant.SUBSCRIBE_SERVICE_NOTIFYCATION;

	static {
		try {
			httpsUtil = new HttpsUtil();
			httpsUtil.initSSLConfigForTwoWay();
		} catch (Exception e) {
		}
	}

	@Autowired
	public SubscribtionServiceNotificationController(SubscribtionServiceNotificationService subscribtionServiceNotificationService) {
		this.subscribtionServiceNotificationService = subscribtionServiceNotificationService;
	}

	@GetMapping("/deviceDataChanged")
	public String deviceDataChanged() throws Exception {
		String callbackurl_deviceDataChanged = Constant.DEVICE_DATA_CHANGED_CALLBACK_URL;
		String notifyType_deviceDataChanged = Constant.DEVICE_DATA_CHANGED;
		String appId = Constant.APPID;
		String accessToken = "";

		Map<String, String> paramSubscribe_deviceDataChange = new HashMap<>();
		paramSubscribe_deviceDataChange.put("callbackurl", callbackurl_deviceDataChanged);
		paramSubscribe_deviceDataChange.put("notifyType", notifyType_deviceDataChanged);
		paramSubscribe_deviceDataChange.put("appId", appId);

		Map<String, String> header_deviceDataChanged = new HashMap<>();
		header_deviceDataChanged.put(Constant.HEADER_APP_KEY, appId);
		header_deviceDataChanged.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

		subscribtionServiceNotificationService.deviceDataChanged(httpsUtil, urlSubscribeServiceNotification, paramSubscribe_deviceDataChange, header_deviceDataChanged);
		return "SUCCESS";
	}
}
