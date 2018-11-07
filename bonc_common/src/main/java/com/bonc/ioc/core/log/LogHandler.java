package com.bonc.ioc.core.log;/**
 * Created by wo on 2018-09-25.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * LogHandler模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-25 10:05
 */
@Component
@RabbitListener(queues = {"LOG"})
public class LogHandler {
    @RabbitHandler
    public void process(Exception e) {
        e.getCause();//java.lang.RuntimeException
        e.getStackTrace()[0].getClassName();//
        e.getStackTrace()[0].getLineNumber();//
        e.getStackTrace()[0].getMethodName();//

    }
  }
