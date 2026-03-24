/**
 * @Title NewSSMBOOT
 * @Package com.controller
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.controller;

import com.entity.CustomEntity;
import com.github.pagehelper.PageInfo;
import com.service.CustomService;
import com.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("custom")
public class CustomController {
    @Autowired
    private CustomService customService;

//    显示用户列表信息
    @ResponseBody
    @RequestMapping("/list")
//    同时应该传分页的信息
    public Object list(CustomEntity custom, @RequestParam("page") int page,@RequestParam("limit") int limit){
        PageInfo<CustomEntity> pageInfo = customService.findAll(custom,page,limit);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",0);
        result.put("msg", "查询成功");
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return result;
    }

//    删除
    @ResponseBody
    @RequestMapping("/delete")
//    用新封装对象接收
    public ResultObject<Object> delete(@RequestParam("cust_id") int cust_id) {
        customService.deleteById(cust_id);
        ResultObject<Object> rs =new ResultObject<Object>();
        rs.setCode(0);
        rs.setMsg("删除成功");
        return rs;
    }

//    编辑
    @ResponseBody
    @RequestMapping("/update")
    public ResultObject<Object> update(CustomEntity custom) {
        System.out.println(custom);
        customService.updateById(custom);
        ResultObject<Object> rs =new ResultObject<Object>();
        rs.setCode(0);
        rs.setMsg("更新成功");
        return rs;
    }

//    添加
    @ResponseBody
    @RequestMapping("/add")
    public ResultObject<Object> add(CustomEntity custom) {
        System.out.println(custom);
        customService.add(custom);
        ResultObject<Object> rs =new ResultObject<Object>();
        rs.setCode(0);
        rs.setMsg("更新成功");
        return rs;
    }
}
