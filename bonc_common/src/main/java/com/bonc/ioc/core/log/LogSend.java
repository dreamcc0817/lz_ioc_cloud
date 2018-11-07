package com.bonc.ioc.core.log;/**
 * Created by wo on 2018-09-25.
 */

import com.bonc.ioc.core.exception.McpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * LogSend模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-25 9:55
 */
@Component
public class LogSend {

    public final static String QUEUE_NAME_LOG="LOG";

    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendMcpException(McpException mcpExecption){
        this.amqpTemplate.convertAndSend(QUEUE_NAME_LOG,mcpExecption);
    }
    public void sendRuntimeException(RuntimeException runException){
        this.amqpTemplate.convertAndSend(QUEUE_NAME_LOG,runException);
    }

}
