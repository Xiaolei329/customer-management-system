/**
 * @Title NewSSMBOOT
 * @Package com.controller
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.controller;

import com.entity.DictionaryEntity;
import com.service.DictionaryService;
import com.vo.CustomLevel;
import com.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

//    查询选项信息
    @ResponseBody
    @RequestMapping("/CustomSourceAndIndustryAndLevel")
    public ResultObject<Object> CustomSourceAndIndustryAndLevel(){
        //查询来源选项
        List<DictionaryEntity> ly_list =  dictionaryService.selectByTypeName("custom_source");
        List<String> customSourceList = new ArrayList<>();
        for(DictionaryEntity dic : ly_list){
            customSourceList.add(dic.getDict_item_name());
        }
        //查询行业选项
        List<DictionaryEntity> hy_list =  dictionaryService.selectByTypeName("custom_industry");
        List<String> customIndustryList = new ArrayList<>();
        for(DictionaryEntity dic : hy_list){
            customIndustryList.add(dic.getDict_item_name());
        }

        //查询级别选项
        List<DictionaryEntity> jb_list =  dictionaryService.selectByTypeName("custom_level");
        List<String> customLevelList = new ArrayList<>();
        for(DictionaryEntity dic : jb_list){
            customLevelList.add(dic.getDict_item_name());
        }

        //返回三个类型的选项信息
        CustomLevel customLevel = new CustomLevel();
        customLevel.setCustomSourceList(customSourceList);
        customLevel.setCustomIndustryList(customIndustryList);
        customLevel.setCustomLevelList(customLevelList);

        ResultObject<Object> rs =new ResultObject<Object>();
        rs.setCode(0);
        rs.setMsg("查询成功");
        rs.setData(customLevel);
        return rs;
    }
}
