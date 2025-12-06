package com.service.impl;

import com.example.mapper.UserDao;
import com.domain.TabUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TransactDemo testInsert;

    @Override
    public TabUser selectUser(int userId) {
        TabUser tabUser = userDao.selectUser(userId);
        return tabUser;
    }

    @Override
    public PageInfo<TabUser> pageUser() {
        PageHelper.startPage(2,4);
        List<TabUser> tabUsers = userDao.userPage();
        PageInfo<TabUser> pageUser=new PageInfo<TabUser>(tabUsers);
        return pageUser;
    }


    @Transactional(rollbackFor = Exception.class)
    public void insertUser(TabUser user) throws Exception {
        List<TabUser> list=new ArrayList<>();
        TabUser tabUser = new TabUser();
        tabUser.setUserId(new Random().nextInt());
        tabUser.setUserName("张三");
        tabUser.setAddress("湖南");

        TabUser tabUser2 = new TabUser();
        tabUser2.setUserId(new Random().nextInt());
        tabUser2.setUserName("李四");
        tabUser2.setAddress("深圳");

        list.add(tabUser);
        list.add(tabUser2);
        try{
            testInsert.testInsert(list);
        }catch (Exception e){
            throw e;
        }
            throw new Exception("测试出错了");

    }


}
