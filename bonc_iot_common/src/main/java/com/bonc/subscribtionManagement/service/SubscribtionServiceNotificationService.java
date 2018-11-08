package com.bonc.subscribtionManagement.service;

import com.bonc.utils.HttpsUtil;

import java.util.Map;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.subscribtionManagement.service
 * @Description:
 * @Author: dreamcc
 * @Date: 2018-11-07 14:03
 * @Version: V1.0
 */
public interface SubscribtionServiceNotificationService {

	/**
	 * subscribe deviceDataChanged notification
	 *
	 * @param httpsUtil
	 * @param paramSubscribe
	 */
	void deviceDataChanged(HttpsUtil httpsUtil, String urlSubscribeServiceNotification, Map<String, String> paramSubscribe, Map<String, String> header_deviceDataChanged) throws Exception;
}
