package com.mapper;

import com.entity.DictionaryEntity;

import java.util.List;

public interface DictionaryMapper {
//    通过分类名称分类查找
    List<DictionaryEntity> selectByTypeName(String typeName);
}
