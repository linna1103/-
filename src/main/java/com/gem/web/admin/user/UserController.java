package com.gem.web.admin.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.entity.Food;
import com.gem.entity.SysDict;
import com.gem.entity.User;
import com.gem.service.SysDictService;
import com.gem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:41
 * @Description:
 */

@Controller
@RequestMapping("/a/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User get(Integer id){
        if (id != null){
            return userService.getById(id);
        }else{
            return new User();
        }
    }

    @RequestMapping("/list")
    public String list(){
        return "user/userList";
    }

    /**
     * 用于数据的展示
     * @param pageIndex 分页时的初始下标
     * @param pageSize  展示数据的条数
     * @return
     */
    @RequestMapping("/getListData")
    @ResponseBody
    public Map<String,Object> getListData(Integer pageIndex, Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        IPage<User> pageList = userService.findPageList(pageIndex,pageSize);
        map.put("data",pageList.getRecords());
        map.put("count",pageList.getTotal());
        return map;
    }

    @RequestMapping("/form")
    public String form(User user, Model model){
        List<User> typeDicts = userService.list(new QueryWrapper<User>()
                .eq("id",user.getId()));
        model.addAttribute("typeDicts",typeDicts);
        model.addAttribute("user",user);
        return "user/userForm";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(User user){
        userService.saveUser(user);
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(User user){
        userService.removeById(user.getId());
        return "success";
    }

    @RequestMapping("/console")
    public String console(Model model){
        Integer count = userService.count();
        model.addAttribute("count",count);
        return "sys/console";
    }

}
