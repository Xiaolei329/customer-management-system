/**
 * @Title NewSSMBOOT
 * @Package com.vo
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.vo;

import lombok.Data;

import java.util.List;
//封装对象
@Data
public class CustomLevel {
    //客户来源
    private List<String> customSourceList;

    //客户所属行业
    private List<String> customIndustryList;

    //客户级别
    private List<String> customLevelList;

}
