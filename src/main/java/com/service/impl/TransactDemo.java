package com.service.impl;

import com.example.mapper.UserDao;
import com.domain.TabUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactDemo {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public void testInsert(List<TabUser> list)  {
        for (TabUser tabUser1 : list) {
                userDao.insertUser(tabUser1);
//                if(tabUser1.getUserName().equals("张三")){
//                    throw new ServiceException("张三出错了");
//                }
        }
    }
}
