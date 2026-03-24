package com.mapper;

import com.entity.CustomEntity;

import java.util.List;

public interface CustomMapper {
//    通过ID查找
    CustomEntity findById(Integer id);
//    查找全部
    List<CustomEntity> findAll(CustomEntity custom);
//    通过ID删除
    void deleteById(Integer id);
//    添加用户
    void add(CustomEntity custom);
//    编辑用户
    void updateById(CustomEntity custom);
}
