package com.bonc.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc
 * @Description:
 * @Author: dreamcc
 * @Date: 2018-11-08 11:11
 * @Version: V1.0
 */
//@Configuration
public class HttpsConfig {
	//@Bean
	public EmbeddedServletContainerFactory servletContainerFactory() {
		TomcatEmbeddedServletContainerFactory tomcatConfig = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				// 这里不知道为什么，只能配置以/*结尾的path。这样配置表示全部请求使用安全模式，必须走https
				collection.addPattern("/*");
				//另外还可以配置哪些请求必须走https，这表示以/home/开头的请求必须走https
				collection.addPattern("/home/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcatConfig.addAdditionalTomcatConnectors(this.newHttpConnector());
		return tomcatConfig;
	}

	private Connector newHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		// 如果只需要支持https访问，这里把收到的http请求跳转到https的端口
		connector.setRedirectPort(8446);
		return connector;
	}
}
