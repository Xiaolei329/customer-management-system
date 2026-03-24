/**
 * @Title NewSSMBOOT
 * @Package com.service
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.service;

import com.entity.CustomEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomService {
    @Autowired
    private CustomMapper customMapper;

    public CustomEntity findById(Integer id){
        return customMapper.findById(id);
    }
//    传分页数量和每页大小
    public PageInfo<CustomEntity>findAll(CustomEntity custom,int pageNum,int pageSize){
//        开启分页
        PageHelper.startPage(pageNum,pageSize);
//        查询分页信息
        List<CustomEntity> list = customMapper.findAll(custom);
//        生成PageInfo对象
        PageInfo<CustomEntity> pageInfo = new PageInfo<CustomEntity>(list);
        return pageInfo;
    }
//    删除
    public void deleteById(Integer id){
        customMapper.deleteById(id);
    }
//    添加
    public void add(CustomEntity custom){
        customMapper.add(custom);
    }
//    编辑
    public void updateById(CustomEntity custom){
        customMapper.updateById(custom);
    }
}
