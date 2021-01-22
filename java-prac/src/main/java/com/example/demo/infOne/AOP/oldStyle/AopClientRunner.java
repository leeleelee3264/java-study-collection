package com.example.demo.infOne.AOP.oldStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-01-22
 * Description:
 */
@Component
public class AopClientRunner implements ApplicationRunner {

    @Autowired
    AopInterface aopInterface;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        aopInterface.readMethod();
        aopInterface.writeMethod();
        aopInterface.deleteMethod();
    }

}
