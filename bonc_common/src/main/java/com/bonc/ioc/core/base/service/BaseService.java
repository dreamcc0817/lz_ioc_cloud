/*
 * Copyright(C)2016-2020 BONC Software Co. Ltd. All rights reserved.
 * 系统名称：bonc_ioc_imp 1.0
 * 作者：左明强 && 手机：13522126905
 * 版本号                                                     日   期                       作     者                  变更说明
 * BaseService-V1.0     2016/09/06  左明强                  新建
 */
package com.bonc.ioc.core.base.service;

import com.bonc.ioc.core.support.HttpKit;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


/**
 * <p> 名       称：业务层操作基类
 * <p> 功       能：包含业务层操作公共功能操作方法
 * <p> 作       者： 左明强
 * <p> 联系方式：13522126905
 * <p> 创建时间：2016/09/06 10:00:00 
 * <p> 特殊情形： 无
 */
 public class BaseService {


	protected HashMap<String, Object> getParamMap(){
		//获取分页参数
		HttpServletRequest request = HttpKit.getRequest();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", request.getParameter("pageSize"));//分页输入
		map.put("currentPage", request.getParameter("pageNumber"));//分页输入
		map.put("findAll", request.getParameter("findAll")==null?
				false:Boolean.parseBoolean(request.getParameter("findAll")));//分页输入
		return map;
	}
	protected String getColumnName(String filed){
		StringBuffer sb = new StringBuffer();
		for(char c : filed.toCharArray()){
			if(c >= 'A' && c < 'Z' ){
				sb.append(("_"+c).toLowerCase());
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
}