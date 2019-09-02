package com.gem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description: 用于登录安全的拦截
 */
@Configuration
@EnableWebSecurity
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 用于用户登录的身份认证
     */
    @Autowired
    private UserDetailsService loginUserService;
    /**
     * userDetailsService验证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginUserService).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //解决 SpringSecurityiFrame'X-Frame-Options'to'deny'
        http.headers().frameOptions().disable();
        //禁用跨站请求伪造
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/js/**","/assets/**","/article/**","/front/**").permitAll()
                //.antMatchers("/f/**").permitAll()//前台路径全部放行
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/a/user/login")
                .defaultSuccessUrl("/a/") //登录成功的默认跳转路径
                .failureUrl("/a/user/login?error") //登录失败的跳转路径
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问
    }

}
