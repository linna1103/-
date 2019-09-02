package com.gem.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description: 文件上传的默认配置
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "system")
public class AppConfig {
    public String filepath;
    public String urlpath;
}
