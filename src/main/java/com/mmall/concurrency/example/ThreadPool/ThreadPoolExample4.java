package com.mmall.concurrency.example.ThreadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
//        service.schedule(new Runnable() {
//            @Override
//            public void run() {
//                log.warn("xxx");
//            }
//        },3, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("xxx");
            }
        },1,3, TimeUnit.SECONDS);
//        service.shutdown();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("time run");
            }
        },new Date(),5*1000);
    }
}
