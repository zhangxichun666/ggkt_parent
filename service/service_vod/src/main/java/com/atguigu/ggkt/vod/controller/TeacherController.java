package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    //分页查询
    @ApiOperation(value = "获取分页列表")
    @PostMapping("{page}/{limit}")
    public Result index(@PathVariable("page") Long page, @PathVariable("page") Long limit, @RequestBody(required = false) TeacherQueryVo teacherQueryVo){
        Page<Teacher> pageParam = new Page<>(page,limit);
        //获取条件值
        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();
        //封装条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if(StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }

        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }

        if(!StringUtils.isEmpty(joinDateBegin)){
            wrapper.ge("join_date",joinDateBegin);
        }

        if(!StringUtils.isEmpty(joinDateEnd)){
            wrapper.ge("join_date",joinDateEnd);
        }

        Page<Teacher> pageModel = teacherService.page(pageParam, wrapper);

        return Result.ok(pageModel);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody Teacher teacher){
        teacherService.save(teacher);
        return Result.ok(null);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody Teacher teacher){
        teacherService.updateById(teacher);
        return Result.ok(teacher);
    }


    @ApiOperation(value = "根据id列表")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        teacherService.removeByIds(idList);
        return Result.ok(null);
    }
}

