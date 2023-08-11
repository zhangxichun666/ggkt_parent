package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zxc
 * @since 2023-08-09
 */

@Api(tags = "讲师管理模块")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //查询所有讲师
    /*@ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public List<Teacher> findAllTeacher(){
        List<Teacher> list = teacherService.list();
        return list;
    }*/

    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public Result findAllTeacher(){
        List<Teacher> list = teacherService.list();
        return Result.ok(list);
    }

    //删除讲师
    @ApiOperation("根据ID逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(@PathVariable Long id) {
        boolean isSuccess = teacherService.removeById(id);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    //分页查找
    @ApiOperation("获取分页列表")
    @PostMapping ("findQueryPage/{current}/{limit}")
    public Result index(@PathVariable Long current, @PathVariable Long limit, @RequestBody(required = false) TeacherQueryVo teacherQueryVo){
        Page<Teacher> pageParam = new Page<>(current,limit);
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();
        //IPage<Teacher> pageModel = teacherService.page(pageParam,queryWrapper);
        IPage<Teacher> pageModel ;

        if(teacherQueryVo == null){
            //QueryWrapper<Teacher> teacherQueryWrapper = queryWrapper.select();
            pageModel = teacherService.page(pageParam,null);
            return Result.ok(pageModel);
        }
        if(StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(StringUtils.isEmpty(level)){
            queryWrapper.eq("level",level);
        }
        if(StringUtils.isEmpty(joinDateBegin)){
            queryWrapper.ge("join_date",joinDateBegin);
        }
        if(StringUtils.isEmpty(joinDateEnd)){
            queryWrapper.le("join_date",joinDateEnd);
        }

        pageModel = teacherService.page(pageParam,queryWrapper);
        return Result.ok(pageModel);
    }
}

