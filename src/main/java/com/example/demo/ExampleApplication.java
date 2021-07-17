package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import xyz.erupt.core.annotation.EruptScan;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
@EntityScan
@EruptScan
public class ExampleApplication extends SpringBootServletInitializer {

    //详细使用方法详见项目内 README.md 文件说明
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
        try {
            System.setProperty("java.awt.headless", "false");
            Desktop.getDesktop().browse(new URI("http://localhost:8080"));
        } catch (Exception e) {
            System.setProperty("java.awt.headless", "true");
        }
        System.err.println("详细使用方法，请阅读：README.md");
    }

    //打WAR包的配置
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExampleApplication.class);
    }

}
