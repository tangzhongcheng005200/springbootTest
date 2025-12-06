package com.demo;

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        //创建并启动两个线程
        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
