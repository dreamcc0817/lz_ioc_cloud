package com.bonc.ioc.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @project_name：mcp
 * @package_name：com.bonc.ioc
 * @describe：***
 * @creater wangze (1215360909@qq.com) 
 * @creat_time 2018/5/18 11:37 
 * @changer   ***  
 * @change_time 2018/5/18 11:37 
 * @remark   ***
 * @version V0.1
 */
@Component
public class SpringContext implements ApplicationContextAware {
	/**
	 * 上下文对象实例
	 */
	private static ConfigurableApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
			this.context =  (ConfigurableApplicationContext) applicationContext;
		
	}
	public  ConfigurableApplicationContext getApplicationContext(){
		return context;
	}
}
