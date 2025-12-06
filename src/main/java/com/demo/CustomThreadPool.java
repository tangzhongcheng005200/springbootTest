package com.demo;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool {
    public static void main(String[] args) {
        // 核心参数：核心线程数、最大线程数、空闲线程存活时间、时间单位、任务队列、拒绝策略
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,//核心线程数
                4,//最大线程数
                60,//空闲线程存活时间
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),//任务队列（容量10）
                new ThreadPoolExecutor.CallerRunsPolicy()//拒绝策略
        );
        //提交任务
        for (int i = 0; i <5 ; i++) {
            executor.submit(new DownloadTask("url"+i,"文件"+i));
        }
        executor.shutdown();
    }
}
