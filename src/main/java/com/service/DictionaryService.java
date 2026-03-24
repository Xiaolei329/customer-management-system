/**
 * @Title NewSSMBOOT
 * @Package com.service
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.service;

import com.entity.DictionaryEntity;
import com.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;
//    通过ID查找，传分类名称
    public List<DictionaryEntity> selectByTypeName(String typeName){
        return dictionaryMapper.selectByTypeName(typeName);
    }
}
