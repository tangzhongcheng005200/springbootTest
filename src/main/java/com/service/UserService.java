package com.service;

import com.domain.TabUser;
import com.github.pagehelper.PageInfo;

public interface UserService {
    TabUser selectUser(int userId);

    public PageInfo<TabUser> pageUser();

}
