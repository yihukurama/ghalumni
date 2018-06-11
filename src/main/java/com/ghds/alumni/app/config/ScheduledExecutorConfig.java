package com.ghds.alumni.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 说明： 延迟或周期性执行任务线程池配置
 * @author: ouyaokun
 * @date: Created in 16:50 2018/3/26
 * @modified: by autor in 16:50 2018/3/26
 * @param
 * @return 
 */
@Configuration
public class ScheduledExecutorConfig {

    @Bean
    public ScheduledExecutorService scheduledExecutorService(){
        return new ScheduledThreadPoolExecutor(20);
    }


}
