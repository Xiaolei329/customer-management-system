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
import java.util.Date;

//客户信息
@Data
public class CustomEntity implements Serializable {
//    客户ID
    private int cust_id;
//    客户名
    private String cust_name;
//    负责人ID
    private int cust_user_id;
//    创建人ID
    private int cust_create_id;
//    来源信息
    private String cust_source;
//    所属行业
    private String cust_industry;
//    客户级别
    private String cust_level;
//    联系人
    private String cust_linkman;
//    固定电话
    private String cust_phone;
//    移动电话
    private String cust_mobile;
//    邮政编码
    private String cust_zipcode;
//    联系地址
    private String cust_address;
//    创建时间
    private Date cust_createtime;
}
