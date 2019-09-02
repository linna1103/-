package com.gem.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: linna
 * @Date: 2019/8/26 09:16
 * @Description: 菜品实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("theme_food")
public class Food extends Model<Food> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String themeName;
    private String themePic;
    private String themeDescribe;
    private Date themeTime;
    private String themeDetails;
    private Integer themeType;
    private Integer themeId;

    @TableLogic
    @TableField(value = "delflag")
    private Integer delFlag;

    /**
     * 进行多图片上传
     */
/*    @TableField(exist = false)
    private List<Img>imgs;*/

}
