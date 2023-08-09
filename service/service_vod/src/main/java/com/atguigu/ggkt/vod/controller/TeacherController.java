package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zxc
 * @since 2023-08-09
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

}

