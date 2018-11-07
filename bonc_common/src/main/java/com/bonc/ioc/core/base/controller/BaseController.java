package com.bonc.ioc.core.base.controller;

import com.bonc.ioc.core.page.PageData;
import com.bonc.ioc.core.page.PageResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

public class BaseController {

	protected String id;
	protected String ids;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected PageResult pageResult;

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 得到PageData
	 */
	public PageData getPageData() {
		return new PageData(request);
	}

	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView() {
		return new ModelAndView();
	}
	


	/**
	 * 获取登录用户的IP
	 * 
	 * @throws Exception
	 */
	public String getRemoteIP() throws Exception {
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		return ip;
	}

}