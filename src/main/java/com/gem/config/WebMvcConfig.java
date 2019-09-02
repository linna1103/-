package com.gem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description: 配置两套不同的路径
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

    /**
     * 用于配置访问的路径
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*后台路径*/
        registry.addRedirectViewController("/a","/a/user/login");
        /*前台路径*/
        registry.addRedirectViewController("/f","/f/food/index");//跳转前台路径
    }

    /**
     * 设置图片上传的(文件磁盘图片url 映射)
     * @param registry
     * addResourceHandler:配置的是前段访问的虚拟路径
     * addResourceLocations:配置的是本地图片的保存路径
     */
    @Override
    public void  addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/article/**").addResourceLocations("file:///E:/image/images/");
    }
}
