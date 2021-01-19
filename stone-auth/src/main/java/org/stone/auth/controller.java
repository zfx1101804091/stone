package org.stone.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("auth")
public class controller {

    public String test(){
        String str = "sdasdsaddddd";
        log.info("cacs哈哈哈哈哈哈哈");
        return str;
    }

}
