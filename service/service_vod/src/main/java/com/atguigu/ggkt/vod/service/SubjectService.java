package com.atguigu.ggkt.vod.service;


import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author zxc
 * @since 2023-08-22
 */
public interface SubjectService extends IService<Subject> {

    List<Subject> selectSubjectList(Long id);
}
