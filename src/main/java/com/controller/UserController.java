package com.controller;

import cn.hutool.core.date.DateUtil;
import com.domain.TabUser;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import com.service.impl.RedisThread;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/selectUser")
    public TabUser selectUser(@RequestBody TabUser user) throws InterruptedException {
        Config config=new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379")
        .setTimeout(10000).setPingConnectionInterval(10000);
        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("anyLock");
        lock.lock(10, TimeUnit.SECONDS);
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        TabUser tabUser =new TabUser();
        if(res){
            System.out.println("踹获取锁成功:"+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            try {
                //创建一个线程
                System.out.println("进入踹"+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
                Thread.sleep(10000);
            }finally {
                lock.unlock();
                System.out.println("踹 释放锁"+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            }
        }else{
            System.out.println("踹未拿到锁"+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        }
return tabUser;

    }

    @PostMapping("/isnertUser")
    public String insertUser(@RequestBody TabUser user ) throws Exception {
        DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        System.out.println("进入老二"+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        Config config=new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("anyLock");
        
        boolean res = lock.tryLock(2, 2, TimeUnit.SECONDS);
        TabUser tabUser =new TabUser();
        if(res){
            System.out.println("老二获取锁成功:"+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            try {
                //创建一个线程
                System.out.println("老二执行了"+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));

            }finally {
                lock.unlock();
                System.out.println("老二释放了"+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
            }
        }else{
            System.out.println("未拿到锁");
            return "未拿到锁";
        }
        //userService.insertUser(user);
        return "执行成功";
    }

    @PostMapping("/pageUser")
    public PageInfo<TabUser> pageUser(){
        return  userService.pageUser();
    }
}
