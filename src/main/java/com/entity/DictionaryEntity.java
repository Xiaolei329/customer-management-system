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

//分类信息
@Data
public class DictionaryEntity implements Serializable {
//    字典ID
    private int dict_id;
//    字典代码
    private String dict_type_code;
//    字典名称
    private String dict_type_name;
//    项目名称
    private String dict_item_name;
//    项目代码
    private String dict_item_code;
//    排序值
    private int dict_sort;
//    可用信息
    private String dict_enable;
//    备注信息
    private String dict_memo;
}
