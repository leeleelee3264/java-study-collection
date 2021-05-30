package me.leelee3264.springbootgettingstarted.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-31
 * description
 */
@Component
public class PropertyRunner implements ApplicationRunner {

    @Value("${my.name}")
    String name;

    @Value("${my.age}")
    int age;

    @Value("${my.year}")
    int year;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("++++++++++++++++++++++ pro ++++++++++++++++++++++++++++");
        System.out.println("name: {}" + name);
        System.out.println("age: {}" + age);
        System.out.println("year: {}" + year);
        System.out.println("++++++++++++++++++++++ pro ++++++++++++++++++++++++++++");

    }
}
