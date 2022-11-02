package com.hk.houqinafter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hk.houqinafter.entity.Support;
import com.hk.houqinafter.mapper.SupportMapper;
import com.hk.houqinafter.service.SupportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-04-18
 */
@RestController
@RequestMapping("//support")
public class SupportController {
    @Autowired
    private SupportService supportService;
    @Autowired
    private SupportMapper supportMapper;

    @PostMapping(value = "/add")
    @ApiOperation("添加后勤人员")
    public String add(@Validated @RequestBody Support support, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldErrors().get(0).getDefaultMessage();
        }
        supportService.save(support);
        return "后勤人员注册成功！您的账号为："+support.getSId();
    }

    @PostMapping(value = "/delete")
    @ApiOperation("删除后勤人员")
    public String delete(@RequestBody Support support){
        supportService.removeById(support);
        return "后勤人员删除成功！";
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新后勤人员信息")
    public String update(@RequestBody Support support){
        supportService.updateById(support);
        return "后勤人员信息更新成功！";
    }

    @GetMapping(value = "/selectAll")
    @ApiOperation("查询所有后勤人员")
    public List<Support> selectAll(){
        return supportService.list();
    }

    @GetMapping(value = "/selectBySsex")
    @ApiOperation("通过性别查询后勤人员")
    public List<Support> selectBySsex(@RequestParam("s_sex")Integer sex){
        return supportService.list(new QueryWrapper<Support>().eq("s_sex",sex));
    }

    @GetMapping(value = "/login")
    @ApiOperation("后勤人员登录")
    public boolean Login(@RequestParam("s_id")Integer id,@RequestParam("s_password")String password){
        return supportService.list(new QueryWrapper<Support>().eq("s_id", id).eq("s_password", password)).size() != 0;
    }

    @GetMapping(value = "/info")
    @ApiOperation("后勤人员信息")
    public Support Info(@RequestParam("s_id")Integer sid){
        return supportService.getById(sid);
    }

    @GetMapping(value = "/name")
    @ApiOperation("后勤人员姓名")
    public String Name(@RequestParam("s_id")Integer sid){
        return supportService.getById(sid).getSName();
    }

    @GetMapping(value = "/allName")
    @ApiOperation("所有后勤人员姓名")
    public List<Support> AllName(){
        return supportMapper.getAllSname();
    }

    @GetMapping(value = "/search")
    @ApiOperation("搜索姓名")
    public List<Support> Search(@RequestParam("text")String text){
        return supportService.list(new QueryWrapper<Support>().like(!text.equals(""),"s_name",text));
    }
}
