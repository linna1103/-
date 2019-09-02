package com.gem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gem.entity.SysUser;
import com.gem.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: linna
 * @Date: 2019/8/26 15:34
 * @Description:
 */
@Service
public class LoginUserService implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        SysUser user = sysUserMapper.selectOne(queryWrapper);
        if (user != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            return new User(user.getUserName(), user.getUserPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
    }
}
