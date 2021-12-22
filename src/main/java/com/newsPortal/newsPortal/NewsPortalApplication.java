package com.newsPortal.newsPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class NewsPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsPortalApplication.class, args);
    }

}
