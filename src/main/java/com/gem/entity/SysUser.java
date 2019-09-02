package com.gem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description: 管理员实体类
 */
@Data
@TableName("TB_USER")
public class SysUser extends Model<SysUser> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String userPassword;
    @TableLogic
    private Integer delFlag;
}
