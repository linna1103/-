package com.gem.web.admin.food;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.ui.Model;
import com.gem.entity.Comment;
import com.gem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Jade
 * @Date: 2019/8/22 11:49
 * @Description: 订单信息的控制器
 */
@Controller
@RequestMapping("/a/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

/*    *//**
     * 以分页的形式展示数据
     * @param pageIndex
     * @param pageSize
     * @return
     *//*
    @RequestMapping("/getListData")
    @ResponseBody
    public Map<String ,Object> getListData(Integer pageIndex,Integer pageSize){
        Map<String ,Object>map = new HashMap<>();
        IPage<Comment>pageList = commentService.findPageList(pageIndex,pageSize);
        *//**
         *获取page
         *//*
        map.put("data",pageList.getRecords());
        *//**
         * 统计查询总数
         *//*
        map.put("count",pageList.getTotal());
        return map;
    }*/

    @RequestMapping("/list")
    public String form(Model model){
        List<Comment> list = commentService.findComment();
        model.addAttribute("list",list);
        return "comment/commentList";
    }

    /**
     * 删除评论
     * @param comment
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteComment(Comment comment){
        commentService.removeById(comment.getId());
        return "success";
    }

}
