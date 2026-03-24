/**
 * @Title NewSSMBOOT
 * @Package com.vo
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.vo;

import lombok.Data;

//封装管理员对象
public class UserInfo {
    private int id;
    private String userName;
    private String password;
    private String verifyCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
