package com.ghds.alumni.app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTools {

    @Autowired
    ScheduledExecutorService scheduledExecutorService;

    public ScheduledFuture runTaskWithDelay(Runnable runnable, Integer delay, TimeUnit unit){
        return scheduledExecutorService.schedule(runnable, delay, unit);
    }

    public ScheduledFuture runTaskWithDelayMinute(Runnable runnable, Integer delay){
        return runTaskWithDelay(runnable, delay, TimeUnit.MINUTES);
    }

    public ScheduledFuture runTaskWithDelaySecond(Runnable runnable, Integer delay){
        return runTaskWithDelay(runnable, delay, TimeUnit.SECONDS);
    }

    public ScheduledFuture runTaskWithDelayHour(Runnable runnable, Integer delay){
        return runTaskWithDelay(runnable, delay, TimeUnit.HOURS);
    }

    public ScheduledFuture runTaskWithDelayDay(Runnable runnable, Integer delay){
        return runTaskWithDelay(runnable, delay, TimeUnit.DAYS);
    }
}
