package com.gem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.entity.Comment;
import com.gem.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description:
 */
@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment> {
    /**
     * 定义分页的初始页
     */
    // public static Integer CURRENT_PAGE = 1;
    /**
     * 定义每页显示的记录条数
     */
    // public static Integer PAGE_SIZE = 5;

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> findComment(){
        return commentMapper.selectComment();
    }

    public Integer count(){
        return commentMapper.count();
    }

/*    *//**
     * 进行分页查询
     * @param page
     * @param size
     * @return
     *//*
    public IPage<Comment>findPageList(Integer page,Integer size){
        if (page != null){
            CURRENT_PAGE = page;
        }
        if (size != null){
            PAGE_SIZE = size;
        }
        IPage<Comment>pageOrders = commentMapper.selectPage(
                new Page<>(CURRENT_PAGE,PAGE_SIZE),
                new QueryWrapper<>());
        return pageOrders;
    }*/
}
