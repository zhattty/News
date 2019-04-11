package com.qiafan.web4j.qiafan.mapper;

import com.qiafan.web4j.qiafan.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer countUserByUsername(String username);

    User selectUserByNameAndPassword(@Param("name") String username,@Param("password") String password);
}