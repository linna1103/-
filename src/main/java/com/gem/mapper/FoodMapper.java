package com.gem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description:
 */
@Repository
public interface FoodMapper extends BaseMapper<Food> {


    //count
    Integer count();
}
