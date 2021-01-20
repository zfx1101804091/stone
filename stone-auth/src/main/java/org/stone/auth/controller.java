package org.stone.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("auth")
public class controller {

    @GetMapping("ts")
    public String test(){
        Date date = new Date();
        // SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);

        // DateTimeFormatter
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = dtf.format(localDateTime);

        // TODO 解决slf4j中Logger.info 只打印出文字没有参数中的数据 -> 使用占位符 {}
        log.info("记录当前时间：普通时间： {}, 本地时间： {}",time, localTime);
        String t = "普通日期 通过 SimpleDateFormat 进行格式化 "+time+"<br>本地时间LocalDateTime 通过 DateTimeFormatter 进行格式化 "+localTime;
        return t;
    }

}
