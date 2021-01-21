package org.stone.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ts")
public class TestController {

    @GetMapping("/t1")
    public String test1(){
        return "test1";
    }
}
