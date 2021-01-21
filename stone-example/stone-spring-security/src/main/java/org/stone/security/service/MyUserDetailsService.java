package org.stone.security.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.stone.security.entity.Users;
import org.stone.security.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询数据库
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<Users>();
        Users users = userMapper.selectOne(queryWrapper.eq(Users::getUsername, username));
        if(users==null){
            //认证失败
        }
        List<GrantedAuthority> auths = AuthorityUtils
                .commaSeparatedStringToAuthorityList("role");
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode("123"),auths);
    }
}
