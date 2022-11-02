package com.hk.houqinafter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hk.houqinafter.entity.Admin;
import com.hk.houqinafter.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("//admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/update")
    @ApiOperation("更新管理员信息")
    public String update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return "管理员信息更新成功！";
    }

    @GetMapping(value = "/selectAll")
    @ApiOperation("查询所有管理员")
    public List<Admin> selectAll(){
        return adminService.list();
    }

    @GetMapping(value = "/login")
    @ApiOperation("管理员登录")
    public boolean Login(@RequestParam("a_id")Integer id,@RequestParam("a_password")String password){
        return adminService.list(new QueryWrapper<Admin>().eq("a_id", id).eq("a_password", password)).size() != 0;
    }

    @GetMapping(value = "/info")
    @ApiOperation("管理员信息")
    public Admin Info(@RequestParam("a_id")Integer aid){
        return adminService.getById(aid);
    }
}
