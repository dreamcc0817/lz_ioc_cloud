package com.bonc.ioc.core.thread;/**
 * Created by wo on 2018-09-28.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ThreadPoolConfig模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-28 15:16
 */
@Component
@PropertySource(value = {"classpath:threadpool.properties"})
@ConfigurationProperties(value = "thread.pool")
public class ThreadPoolConfig {

    // 线程池的基本大小
    private int corePoolSize;
    //线程池最大数量
    private int maximumPoolSize;
    //线程活动保持时间
    private int keepActiveTime;
    //线程活动保持时间的单位
     // 任务队列类型
    private String taskQueueType;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public int getKeepActiveTime() {
        return keepActiveTime;
    }

    public void setKeepActiveTime(int keepActiveTime) {
        this.keepActiveTime = keepActiveTime;
    }

    public String getTaskQueueType() {
        return taskQueueType;
    }

    public void setTaskQueueType(String taskQueueType) {
        this.taskQueueType = taskQueueType;
    }
}
