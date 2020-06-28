package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        test();
    }

    public static void test() {
        threadLocal.set("1");
        get();
    }

    public static void get() {

        System.out.println(threadLocal.get());
    }

}
