package org.stone;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class StoneAuthApp {
    public static void main(String[] args) {
        SpringApplication.run(StoneAuthApp.class,args);
    }
}
