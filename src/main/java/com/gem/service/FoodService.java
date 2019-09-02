package com.gem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.entity.Food;
import com.gem.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description:
 */
@Service
public class FoodService extends ServiceImpl<FoodMapper, Food> {
    public static Integer CURRENT_PAGE = 1;
    public static Integer PAGE_SIZE = 2;

    @Autowired
    private FoodMapper foodMapper;

    /**
     * 分页
     * @param page
     * @param size
     * @return
     */

    public IPage<Food> findPageList(Integer page,Integer size){
        if (page != null){
            CURRENT_PAGE = page;
        }
        if (size != null){
            PAGE_SIZE = size;
        }
        IPage<Food> pageFood = foodMapper.selectPage(
                new Page<>(CURRENT_PAGE,PAGE_SIZE),
                new QueryWrapper<>());
        return pageFood;
    }

    /**
     * 保存数据
     * @param food
     */
    public void saveFood(Food food){
        if (food.getId() != null){
            foodMapper.updateById(food);
        }else {
            food.setThemeId(10086);
            food.setThemeTime(new Date());
            foodMapper.insert(food);
        }
    }

    public Integer count(){
        return foodMapper.count();
    }
}
