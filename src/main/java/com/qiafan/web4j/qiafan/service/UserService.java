package com.qiafan.web4j.qiafan.service;

import com.qiafan.web4j.qiafan.bean.User;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 15:42
 */

public interface UserService {
    Boolean checkUserName(String username);

    int insertUser(User user);

    User selectUserByNameAndPassword(String username, String password);
}
