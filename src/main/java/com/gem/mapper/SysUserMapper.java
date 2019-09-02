package com.gem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.entity.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description: 管理员接口
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 通过用户名找出所对应的用户密码
     * @param userName
     * @return
     */
    SysUser findUserByName(String userName);
}
