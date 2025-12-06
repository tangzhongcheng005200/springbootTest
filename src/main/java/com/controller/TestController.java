package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.pojo.KaiHu;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestController {
//    @Value("${value}")
//    String port;
//    @RequestMapping("demo1")
//    public String demo(){
//        return "hello world!"+"-->"+port;
//    }

    @PostMapping("/demo2")
    public String demo2(@RequestBody String str){
        ArrayList<KaiHu> kaihu=JSON.parseObject(str,new TypeReference<ArrayList<KaiHu>>(){});
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<KaiHu> dd=JSON.parseObject(str,ArrayList.class);
        System.out.println(JSON.toJSONString(kaihu));
        HashMap<String, Object> map = new HashMap<>();
        map.put("_list",dd);
        System.out.println("转换后:"+JSON.toJSONString(map));
        return "123";
    }
}
