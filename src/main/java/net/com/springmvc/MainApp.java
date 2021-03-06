package net.com.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching 
public class MainApp {
   public static void main(String[] args) {
	   SpringApplication app = new SpringApplication(MainApp.class);
       app.run(args);
   }
}
