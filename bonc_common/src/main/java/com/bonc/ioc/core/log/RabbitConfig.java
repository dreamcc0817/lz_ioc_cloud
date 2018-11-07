package com.bonc.ioc.core.log;/**
 * Created by wo on 2018-09-25.
 */

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitConfig模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-25 10:07
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue LogQueue(){
        return new Queue("LOG");
    }
}
