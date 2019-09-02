package com.gem.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("menu_comment")
public class Comment extends Model<Comment> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String menuText;
    private Date commentTime;
    private Integer themefoodId;
    private Integer themeuserId;
    @TableField
    private String username;
    @TableField
    private String themeName;
    @TableLogic
    private Integer delFlag;
}
