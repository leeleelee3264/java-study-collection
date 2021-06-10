package me.leelee3264.springbootgettingstarted.runner;

import me.leelee3264.springbootgettingstarted.component.MyProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    MyProperties myProperties;

    private final Logger log = LoggerFactory.getLogger(PropertyRunner.class);
//
//    @Autowired
//    private String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("++++++++++++++++++++++ pro ++++++++++++++++++++++++++++");
        log.debug("name: {}" + name);
        log.debug("++++++++++++++++++++++ pro ++++++++++++++++++++++++++++");

        System.out.println("\n++++++++++++++++++++++ new pro ++++++++++++++++++++++++++++");
        System.out.println(myProperties.getName());
        System.out.println(myProperties.getAge());
        System.out.println(myProperties.getFullName());

        System.out.println("++++++++++++++++++++++ pro ++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++ pro ++++++++++++++++++++++++++++");
        System.out.println("code change");
        System.out.println("code changae3");
    }
}
