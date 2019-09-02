package com.gem.web.admin.food;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.entity.Food;
import com.gem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: linna
 * @Date: 2019/8/13 20:54
 * @Description:
 */
@Controller
@RequestMapping("/a/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @ModelAttribute("food")
    public Food get(Integer id){
        if (id != null){
            return foodService.getById(id);
        }else{
            return new Food();
        }
    }

    @RequestMapping("/list")
    public String list(){
        return "food/foodList";
    }

    /**
     * 用于数据的展示
     * @param pageIndex 分页时的初始下标
     * @param pageSize  展示数据的条数
     * @return
     */
    @RequestMapping("/getListData")
    @ResponseBody
    public Map<String,Object>getListData(Integer pageIndex,Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        IPage<Food>pageList = foodService.findPageList(pageIndex,pageSize);
        map.put("data",pageList.getRecords());
        map.put("count",pageList.getTotal());
        return map;
    }

    @RequestMapping("/form")
    public String form(Food food, Model model){
        List<Food> typeDicts = foodService.list(new QueryWrapper<Food>()
                .eq("id",food.getId()));
        model.addAttribute("typeDicts",typeDicts);
        model.addAttribute("food",food);
        return "food/foodForm";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(Food food){
        foodService.saveFood(food);
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Food food){
        foodService.removeById(food.getId());
        return "success";
    }

}
