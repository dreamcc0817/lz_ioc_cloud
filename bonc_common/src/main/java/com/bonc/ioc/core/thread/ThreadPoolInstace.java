package com.bonc.ioc.core.thread;/**
 * Created by wo on 2018-09-28.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.*;

/**
 * ThreadPoolInstace模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-28 14:29
 */
@Configuration
@PropertySource(value = {"classpath:threadpool.properties"})
@SuppressWarnings("all")
public class ThreadPoolInstace {

    @Autowired
    private ThreadPoolConfig threadPoolConfig;
   //线程活动保持时间的单位
    private TimeUnit timeUnit=TimeUnit.SECONDS;



    @Bean(name="blockingQueue")
    public BlockingQueue<Runnable> blockingQueue(){
        if(threadPoolConfig.getTaskQueueType().equals("array")){
            return new ArrayBlockingQueue<Runnable>(threadPoolConfig.getCorePoolSize());
        }else if(threadPoolConfig.getTaskQueueType().equals("linked")){
            return new LinkedBlockingDeque<Runnable>(threadPoolConfig.getCorePoolSize());
        }else if(threadPoolConfig.getTaskQueueType().equals("sync")){
            return new SynchronousQueue<Runnable>();//不存储元素的队列
        }else if(threadPoolConfig.getTaskQueueType().equals("priority")){
            return new PriorityBlockingQueue<Runnable>(threadPoolConfig.getCorePoolSize());
        }else{
            return new ArrayBlockingQueue<Runnable>(threadPoolConfig.getCorePoolSize());
        }
    }

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(@Qualifier(value = "blockingQueue") BlockingQueue<Runnable> blockingQueue){
        return new ThreadPoolExecutor(threadPoolConfig.getCorePoolSize(),threadPoolConfig.getMaximumPoolSize(),threadPoolConfig.getKeepActiveTime(),timeUnit,blockingQueue);
    }


}
