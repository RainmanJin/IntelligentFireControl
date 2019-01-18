package cn.com.bgy.ifc.config.api;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author: ZhangCheng
 * @description:设置定时任务并发执行
 * @date: 2019-01-18 10:58
 **/
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //手动设置线程池，并发执行线程数为5
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(5,new BasicThreadFactory.Builder().namingPattern("scheduled-pool-%d").daemon(true).build());
        scheduledTaskRegistrar.setScheduler(scheduledExecutorService);
    }
}