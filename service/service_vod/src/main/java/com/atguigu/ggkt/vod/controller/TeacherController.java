package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public List<Teacher> findAllTeacher(){
        List<Teacher> list = teacherService.list();
        return list;
    }
    //删除讲师
    @ApiOperation("根据ID逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public boolean removeTeacher(@PathVariable Long id){
        boolean isSuccess = teacherService.removeById(id);
        return isSuccess;
    }
}

