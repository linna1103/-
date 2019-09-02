package com.gem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:36
 * @Description:
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    //count
    Integer count();

}
