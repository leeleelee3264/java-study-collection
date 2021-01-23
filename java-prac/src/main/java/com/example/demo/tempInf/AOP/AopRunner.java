package com.example.demo.tempInf.AOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
@Component
public class AopRunner implements ApplicationRunner {

    @Autowired
    AopService aopService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        aopService.actRead();
        aopService.actWrite();
        aopService.actDelete();
    }
}
