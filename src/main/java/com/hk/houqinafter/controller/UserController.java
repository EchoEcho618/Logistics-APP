package com.hk.houqinafter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hk.houqinafter.entity.User;
import com.hk.houqinafter.mapper.UserMapper;
import com.hk.houqinafter.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-04-18
 */
@RestController
@RequestMapping("//user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/add")
    @ApiOperation("添加用户")
    public String add(@Validated @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return Objects.requireNonNull(bindingResult.getFieldErrors()).get(0).getDefaultMessage();
        userService.save(user);
        return "用户注册成功！您的账号为："+user.getUId();
    }

    @PostMapping(value = "/delete")
    @ApiOperation("删除用户")
    public String delete(@RequestBody User user){
        userService.removeById(user);
        return "用户删除成功！";
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新用户信息")
    public String update(@RequestBody User user){
        userService.updateById(user);
        return "用户信息更新成功！";
    }

    @GetMapping(value = "/selectAll")
    @ApiOperation("查询所有用户")
    public List<User> selectAll(){
        return userService.list();
    }

    @GetMapping(value = "/selectByUsex")
    @ApiOperation("通过性别查询用户")
    public List<User> selectByUsex(@RequestParam("u_sex")Integer sex){
        return userService.list(new QueryWrapper<User>().eq("u_sex",sex));
    }

    @GetMapping(value = "/selectByUtype")
    @ApiOperation("通过类型查询用户")
    public List<User> selectByUtype(@RequestParam("u_type")Integer type){
        return userService.list(new QueryWrapper<User>().eq("u_type",type));
    }

    @GetMapping(value = "/selectByUsexAndUtype")
    @ApiOperation("通过性别和类型查询用户")
    public List<User> selectByUsexAndUtype(@RequestParam("u_sex")Integer sex,@RequestParam("u_type")Integer type){
        return userService.list(new QueryWrapper<User>().eq("u_sex",sex).eq("u_type",type));
    }

    @GetMapping(value = "/login")
    @ApiOperation("用户登录")
    public boolean Login(@RequestParam("u_id")Integer id,@RequestParam("u_password")String password){
        return userService.list(new QueryWrapper<User>().eq("u_id", id).eq("u_password", password)).size() != 0;
    }

    @GetMapping(value = "/info")
    @ApiOperation("用户信息")
    public User Info(@RequestParam("u_id")Integer uid){
        return userService.getById(uid);
    }

    @GetMapping(value = "/name")
    @ApiOperation("用户姓名")
    public String Name(@RequestParam("u_id")Integer uid){
        return userMapper.getUname(uid);
    }

    @GetMapping(value = "/allName")
    @ApiOperation("所有用户姓名")
    public List<User> AllName(){
        return userMapper.getAllUname();
    }

    @GetMapping(value = "/search")
    @ApiOperation("搜索姓名")
    public List<User> Search(@RequestParam("text")String text){
        return userService.list(new QueryWrapper<User>().like(!text.equals(""),"u_name",text));
    }
}
