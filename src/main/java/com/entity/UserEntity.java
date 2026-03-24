/**
 * @Title NewSSMBOOT
 * @Package com.entity
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.entity;

import lombok.Data;

import java.io.Serializable;

//后台管理员信息
@Data
public class UserEntity implements Serializable {
//    管理ID
    private int user_id;
//    管理账号
    private String user_code;
//    管理用户名
    private String user_name;
//    管理密码
    private String user_password;
//    管理状态
    private String user_state;
}
