package com.example.demo.tempInf.AOP;

import org.springframework.stereotype.Service;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
@Service
public class AopServiceImp implements AopService {

    @AopAnno
    @Override
    public void actRead() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AopServiceImp.actRead");
    }

    @AopAnno
    @Override
    public void actWrite() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AopServiceImp.actWrite");
    }

    @Override
    public void actDelete() {
        System.out.println("AopServiceImp.actDelete");
    }
}
