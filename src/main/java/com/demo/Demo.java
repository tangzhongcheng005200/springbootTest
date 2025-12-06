package com.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        String beginTime = "20220322";
        String endTime = "20220321";
        SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date1 = sim.parse(beginTime);
            Date date2 = sim.parse(endTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            cal.add(Calendar.YEAR, 1);
            System.out.println(sim.format(cal.getTime()));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("第一次修改");
        System.out.println("第二次修改我要合并分支了");
        System.out.println("第三次修改");
        System.out.println("第四次提交");
    }
}