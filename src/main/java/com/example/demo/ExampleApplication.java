package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import xyz.erupt.core.annotation.EruptScan;

import java.awt.*;
import java.net.URI;
import java.util.logging.Logger;

@SpringBootApplication
@EruptScan
@EntityScan
public class ExampleApplication {

    private static final Logger logger = Logger.getLogger(ExampleApplication.class.getName());

    //详细使用方法详见项目内 README.md 文件说明
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
        logger.info("Erupt Example Application Started, please visit: http://localhost:8080");
    }

}
