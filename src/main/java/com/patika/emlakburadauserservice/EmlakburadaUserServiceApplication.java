package com.patika.emlakburadauserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmlakburadaUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmlakburadaUserServiceApplication.class, args);
    }

}
