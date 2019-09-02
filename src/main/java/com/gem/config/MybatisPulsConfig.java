package com.gem.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description: 配置mybatisPlus的扫描
 */
@Configuration
@MapperScan(basePackages = "com.gem.mapper")
public class MybatisPulsConfig {
    /**
     * 分页插件
     * @returnn
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
