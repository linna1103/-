package com.gem;

import com.gem.entity.Food;
import com.gem.entity.SysUser;
import com.gem.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantApplicationTests {
    @Autowired
    private FoodService foodService;
    @Test
    public void testInsertFood(){
        Food food = new Food();
        food.setThemeName("鱼香肉丝");
        foodService.saveFood(food);
    }

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void saveUser() {
        SysUser user = new SysUser();
        user.setUserName("abc");
        user.setUserPassword(new BCryptPasswordEncoder().encode("123456"));
        sysUserService.save(user);
    }

    @Autowired
    private UserService userService;


    @Test
    public void findCount(){
        System.out.println(userService.count());
    }

    @Autowired
    private CommentService commentService;

    @Test
    public void findComment(){
        commentService.findComment().forEach(System.out::println);
    }
}
