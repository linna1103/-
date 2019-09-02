package com.gem.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description:
 */
@Data
@TableName(value = "menu_user") //指定具体的表名，如果数据库中表名和该实体类名称一致，可以缺省
public class User extends Model<User>{

    @TableId(type = IdType.AUTO)    //指定该列自动增加
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    @TableLogic
    @TableField(value = "del_flag") //定义数据库列名和实体类属性映射
    private String delFlag;

}
