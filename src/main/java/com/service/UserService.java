/**
 * @Title NewSSMBOOT
 * @Package com.service
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.service;

import com.entity.UserEntity;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
//    登录后台管理，通过用户名查密码，传用户名
    public UserEntity findByUserName(String userName){
        return userMapper.findByUserName(userName);
    }
}
