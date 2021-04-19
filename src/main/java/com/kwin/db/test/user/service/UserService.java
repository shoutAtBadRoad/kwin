package com.kwin.db.test.user.service;


import com.kwin.db.test.user.entity.Admin;
import com.kwin.db.test.user.entity.SystemManager;
import com.kwin.db.test.user.entity.User;
import com.kwin.db.test.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUser(String username,String password){
        return null;
    }

    public Admin getAdmin(String username,String password){
        return userMapper.getAdmin(username,password);
    }

    public SystemManager getSystemManager(String username,String password){
        return userMapper.getSystemManager(username,password);
    }

}
