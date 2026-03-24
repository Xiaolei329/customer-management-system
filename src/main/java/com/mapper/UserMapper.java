package com.mapper;

import com.entity.UserEntity;

public interface UserMapper {
    //后台管理员登录
    UserEntity findByUserName(String userName);
}
