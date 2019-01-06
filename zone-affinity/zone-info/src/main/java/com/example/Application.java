package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
class GatewayApiRest {

    @Value("${eureka.instance.metadata-map.zone}")
    private String zoneName;

    @GetMapping(value = "/")
    public String zoneInfo() throws UnknownHostException {
        String ip = Inet4Address.getLocalHost().getHostAddress();
        return "Service is in " + zoneName + ". Service ip:" + ip;
    }
}
