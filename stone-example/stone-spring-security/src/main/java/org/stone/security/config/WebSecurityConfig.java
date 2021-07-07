package org.stone.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //定义用户信息（查询数据库）
    @Resource
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    //密码编码器
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    //安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()    //自定义登录页面
            .loginPage("/ts/login")
            .loginProcessingUrl("/ts/login") //登录访问路径
            .defaultSuccessUrl("/ts/index").permitAll() //登录成功后跳转路径
            .and().authorizeRequests()
            .antMatchers("/","/ts/login","/ts/t1").permitAll() //设置那些路径不需要认证
            .anyRequest().authenticated()
            .and().csrf().disable(); //关闭crsf防护
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**","/templates/**");
    }
}
