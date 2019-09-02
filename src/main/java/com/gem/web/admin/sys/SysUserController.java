package com.gem.web.admin.sys;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.gem.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Jade
 * @Date: 2019/8/13 15:30
 * @Description: 系统用户控制器
 */
@Controller
@RequestMapping("/a/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录模块
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "sys/login";
    }

}
