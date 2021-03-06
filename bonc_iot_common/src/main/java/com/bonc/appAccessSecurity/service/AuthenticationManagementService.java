package com.bonc.appAccessSecurity.service;

import com.bonc.utils.HttpsUtil;

import java.util.Map;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.appAccessSecurity.service
 * @Description: 鉴权管理
 * @Author: dreamcc
 * @Date: 2018-11-07 09:35
 * @Version: V1.0
 */
public interface AuthenticationManagementService {
	/**
	 * authentication 认证，获取Token
	 *
	 * @param httpsUtil
	 * @param loginUrl
	 * @param loginInfo
	 * @return
	 */
	void authentication(HttpsUtil httpsUtil, String loginUrl, Map<String, String> loginInfo) throws Exception;

	/**
	 * refreshToken 重新获取Token
	 *
	 * @param httpsUtil
	 * @param loginUrl
	 * @param urlRefreshToken
	 * @param loginInfo
	 * @return
	 */
	void refreshToken(HttpsUtil httpsUtil, String loginUrl,String urlRefreshToken, Map<String, String> loginInfo) throws Exception;
}
