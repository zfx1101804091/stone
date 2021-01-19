package org.stone.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@EnableAdminServer
@SpringCloudApplication
public class StoneAdminApp {
    public static void main(String[] args) {
        SpringApplication.run(StoneAdminApp.class,args);
    }
}
