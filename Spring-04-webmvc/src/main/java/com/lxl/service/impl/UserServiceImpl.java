package com.lxl.service.impl;

import com.lxl.dao.UserDao;
import org.springframework.stereotype.Service;
import com.lxl.service.UserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void service() {
        System.out.println("========================================================================================");
        System.out.println("UserServiceImpl object.service() method is called, and then we will call userDao.save():");
        userDao.save();
    }
}
