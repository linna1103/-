package com.gem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.entity.User;
import com.gem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:37
 * @Description:
 */

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    public static Integer CURRENT_PAGE = 1;
    public static Integer PAGE_SIZE = 2;

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页
     * @param page
     * @param size
     * @return
     */

    public IPage<User> findPageList(Integer page, Integer size){
        if (page != null){
            CURRENT_PAGE = page;
        }
        if (size != null){
            PAGE_SIZE = size;
        }
        IPage<User> pageUser = userMapper.selectPage(
                new Page<>(CURRENT_PAGE,PAGE_SIZE),
                new QueryWrapper<>());
        return pageUser;
    }

    /**
     * 保存数据
     * @param user
     */
    public void saveUser(User user){
        if (user.getId() != null){
            userMapper.updateById(user);
        }else {
            userMapper.insert(user);
        }
    }

    public Integer count(){
       return userMapper.count();
    }
}
