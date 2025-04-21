package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import xyz.erupt.core.annotation.EruptScan;

import javax.persistence.Entity;
import java.awt.*;
import java.net.URI;

@SpringBootApplication
@EruptScan
@EntityScan
public class ExampleApplication {

    //详细使用方法详见项目内 README.md 文件说明
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
        try {
            System.setProperty("java.awt.headless", "false");
            Desktop.getDesktop().browse(new URI("http://localhost:8080"));
        } catch (Exception ignore) {
        }
        System.err.println("详细使用方法，请阅读：README.md");
    }

}
