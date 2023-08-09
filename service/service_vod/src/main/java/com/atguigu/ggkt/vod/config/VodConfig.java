package com.atguigu.ggkt.vod.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName VodConfig
 * @Description
 * @Author LENOVO
 * @Date 2023/8/9 9:28
 * @Version 1.0
 */
@Configuration
@MapperScan("com.atguigu.ggkt.vod.mapper")
public class VodConfig {
}
