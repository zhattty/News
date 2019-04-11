package com.qiafan.web4j.qiafan.service.impl;

import com.qiafan.web4j.qiafan.bean.User;
import com.qiafan.web4j.qiafan.mapper.UserMapper;
import com.qiafan.web4j.qiafan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 15:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean checkUserName(String username) {
        return userMapper.countUserByUsername(username) > 0;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User selectUserByNameAndPassword(String username, String password) {
        return userMapper.selectUserByNameAndPassword(username, password);
    }
}
