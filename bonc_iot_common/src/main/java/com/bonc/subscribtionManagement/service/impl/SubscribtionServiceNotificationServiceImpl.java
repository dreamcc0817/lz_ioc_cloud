package com.bonc.subscribtionManagement.service.impl;

import com.bonc.subscribtionManagement.service.SubscribtionServiceNotificationService;
import com.bonc.utils.HttpsUtil;
import com.bonc.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.subscribtionManagement.service.impl
 * @Description:
 * @Author: dreamcc
 * @Date: 2018-11-07 14:04
 * @Version: V1.0
 */
@Slf4j
@Service("subscribtionServiceNotification")
public class SubscribtionServiceNotificationServiceImpl implements SubscribtionServiceNotificationService {
	@Override
	public void deviceDataChanged(HttpsUtil httpsUtil,String urlSubscribeServiceNotification,Map<String, String> paramSubscribe, Map<String, String> header_deviceDataChanged) throws Exception{

		String jsonRequest_deviceDataChanged = JsonUtil.jsonObj2Sting(paramSubscribe);

		HttpResponse httpResponse_deviceDataChanged = httpsUtil.doPostJson(urlSubscribeServiceNotification, header_deviceDataChanged, jsonRequest_deviceDataChanged);

		String bodySubscribe_deviceDataChanged = httpsUtil.getHttpResponseBody(httpResponse_deviceDataChanged);

		log.info("SubscribeServiceNotification: " + paramSubscribe.get("notifyType") + ", response content:");
		log.info(httpResponse_deviceDataChanged.getStatusLine()+"");
		log.info(bodySubscribe_deviceDataChanged);
	}
}
