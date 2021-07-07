package org.stone.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("ts")
public class TestController {

    @GetMapping("/t1")
    @ResponseBody
    public String test1() {
        return "test1";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println("当前用户："+getUserName());
        return "index";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 获取当前用户
     * @return
     */
    public static String getUserName() {
        String username = null;
        //当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //用户身份
        Object principal = authentication.getPrincipal();

        if (principal == null) {
            username = "匿名";
        }

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        }else {
            username=principal.toString();
        }
        return username;
    }
}
