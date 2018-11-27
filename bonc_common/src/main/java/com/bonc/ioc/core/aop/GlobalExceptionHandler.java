package com.bonc.ioc.core.aop;

import com.bonc.ioc.core.base.tips.AppReply;
import com.bonc.ioc.core.exception.McpException;
import com.bonc.ioc.core.log.LogSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

/**
 * 全局的的异常拦截器（拦截所有的控制器）
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午3:19:56
 */
@RestControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	private LogSend logSend;

	/**
	 * 拦截业务异常
	 */
	@ExceptionHandler(McpException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public AppReply notFount(McpException e) {
		//logSend.sendMcpException(e);
		String msg = e.getCause() + "" + e.getStackTrace()[0] + (e.getStackTrace()[0].getLineNumber() + "") + e.getStackTrace()[0].getMethodName();
		log.error("业务异常:", msg);
		return AppReply.error(e.getCode() + "", e.toString());
	}


	/**
	 * 拦截未知的运行时异常
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public AppReply notFount(RuntimeException e) {
		//logSend.sendRuntimeException(e);
		String msg = e.getCause() + "" + e.getStackTrace()[0] + (e.getStackTrace()[0].getLineNumber() + "") + e.getStackTrace()[0].getMethodName();
		log.error("运行时异常:", msg);
		return AppReply.error(msg);
	}
}
