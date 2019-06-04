package com.stylefeng.guns.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qz
 */
@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
public class GunsFilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsFilmApplication.class, args);
    }
}
