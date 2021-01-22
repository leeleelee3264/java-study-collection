package com.example.demo.infOne.AOP.oldStyle;

import org.springframework.stereotype.Service;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-01-22
 * Description:
 */
@Service
public class AopInterfaceImp implements AopInterface {

    @Override
    public void readMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Read method called");
    }

    @Override
    public void writeMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Write method called");
    }

    @Override
    public void deleteMethod() {
        System.out.println("Delete method called");
    }
}
