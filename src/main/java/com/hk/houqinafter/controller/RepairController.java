package com.hk.houqinafter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.hk.houqinafter.entity.Repair;
import com.hk.houqinafter.mapper.RepairMapper;
import com.hk.houqinafter.service.RepairService;
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
@RequestMapping("//repair")
public class RepairController {
    @Autowired
    private RepairService repairService;
    @Autowired
    private RepairMapper repairMapper;

    @PostMapping(value = "/add")
    @ApiOperation("添加报修单")
    public String add(@Validated @RequestBody Repair repair, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return Objects.requireNonNull(bindingResult.getFieldErrors()).get(0).getDefaultMessage();
        repairService.save(repair);
        return "报修单添加成功！";
    }

    @PostMapping(value = "/delete")
    @ApiOperation("删除报修单")
    public String delete(@RequestBody Repair repair){
        repairService.removeById(repair);
        return "报修单删除成功！";
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新报修单信息")
    public String update(@RequestBody Repair repair){
        repairService.updateById(repair);
        return "报修单信息更新成功！";
    }

    @GetMapping(value = "/selectAll")
    @ApiOperation("查询所有报修单")
    public List<Repair> selectAll(){
        return repairService.list();
    }

    @GetMapping(value = "/selectByUid")
    @ApiOperation("通过报修人查询报修单")
    public List<Repair> selectByUid(@RequestParam("u_id")Integer uid){
        return repairService.list(new QueryWrapper<Repair>().eq("u_id",uid));
    }

    @GetMapping(value = "/selectBySid")
    @ApiOperation("通过维修人查询报修单")
    public List<Repair> selectBySid(@RequestParam("s_id")Integer sid){
        return repairService.list(new QueryWrapper<Repair>().eq("s_id",sid));
    }

    @GetMapping(value = "/selectNew")
    @ApiOperation("查询新的报修单")
    public List<Repair> selectNew(){
        return repairService.list(new QueryWrapper<Repair>().isNull("end").isNull("s_id"));
    }

    @GetMapping(value = "/info")
    @ApiOperation("报修单信息")
    public Repair Info(@RequestParam("r_id")Integer rid){
        return repairService.getById(rid);
    }

    @PostMapping(value = "/cancel")
    @ApiOperation("取消报修单")
    public String Cancel(@RequestBody Repair repair){
        repairService.update(new LambdaUpdateWrapper<Repair>().eq(Repair::getRId,repair.getRId()).set(Repair::getSId,null));
        return "取消报修单成功！";
    }

    @GetMapping(value = "/search")
    @ApiOperation("搜索内容")
    public List<Repair> Search(@RequestParam("text")String text){
        return repairService.list(new QueryWrapper<Repair>().like(!text.equals(""),"r_content",text));
    }

    @GetMapping(value = "/avgStar")
    @ApiOperation("平均星级")
    public Double avgStar(@RequestParam("s_id")Integer sid){
        return repairMapper.getAvgStar(sid);
    }
}
