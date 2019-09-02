package com.gem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description: 评论接口
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> selectComment();

    //count
    Integer count();
}
