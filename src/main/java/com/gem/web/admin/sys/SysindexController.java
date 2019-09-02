package com.gem.web.admin.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gem.entity.SysUser;
import com.gem.service.CommentService;
import com.gem.service.FoodService;
import com.gem.service.SysUserService;
import com.gem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: linna
 * @Date: 2019/8/23 15:33
 * @Description:
 */
@Controller
@RequestMapping("/a")
public class SysindexController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("/")
    public String index(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QueryWrapper<SysUser>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userDetails.getUsername());
        model.addAttribute("sysUser",sysUserService.getOne(queryWrapper));
        return "sys/index";
    }

    @RequestMapping("/console")
    public String console(Model model){
        Integer count1 = userService.count();
        Integer count2 = foodService.count();
        Integer count3 = commentService.count();
        model.addAttribute("count1",count1);
        model.addAttribute("count2",count2);
        model.addAttribute("count3",count3);
        return "sys/console";
    }
}
