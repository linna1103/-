package com.gem.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description: 字典类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("TB_CLASS")
public class SysDict extends Model<SysDict> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "typecode")
    private String typecode;
    /**
     * 类别
     */
    private String className;
    /**
     * 字典值
     */
    private String value;
    /**
     * 菜品类型的描述
     */
    private String classDescription;

    @TableLogic
    private Integer delFlag;
}
