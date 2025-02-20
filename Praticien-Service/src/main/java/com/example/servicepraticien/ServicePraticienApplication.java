package com.example.servicepraticien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicePraticienApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePraticienApplication.class, args);
    }

}
