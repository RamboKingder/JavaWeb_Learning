package com.lxl.dao.impl;

import com.lxl.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl object.save() method is called......");
    }
}
