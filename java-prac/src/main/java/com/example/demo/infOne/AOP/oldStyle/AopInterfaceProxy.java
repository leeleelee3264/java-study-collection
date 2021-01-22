package com.example.demo.infOne.AOP.oldStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-01-22
 * Description: proxy class has to implements the same interface with working class.
 * use primary anno to be selected as prim if interface impi twice
 * old style aop has to (1) make proxy to all classes
 *
 *
 * use interface with proxy:
 * 1. don't have to modi original working code to do what i want
 * 2. can add more method without modu original code
 */
@Primary
@Service
public class AopInterfaceProxy implements AopInterface {

    @Autowired
    AopInterfaceImp aopInterfaceImp;

    @Override
    public void readMethod() {
        long begin = System.currentTimeMillis();

        aopInterfaceImp.readMethod();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void writeMethod() {
        long begin = System.currentTimeMillis();

        aopInterfaceImp.writeMethod();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteMethod() {
        long begin = System.currentTimeMillis();

        aopInterfaceImp.deleteMethod();
        System.out.println(System.currentTimeMillis() - begin);
    }

}
