package com.atguigu.ggkt.vod.service;


import com.alibaba.excel.EasyExcel;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.vo.vod.SubjectEeVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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

    /**
     * 查询课程列表
     * @param id
     * @return
     */
    List<Subject> selectSubjectList(Long id);

    /**
     * 课程列表导出功能
     * @param response
     */
    public void exportData(HttpServletResponse response);

    /**
     * 课程列表导入功能
     * @param file
     */
    public void importData(MultipartFile file);
}
