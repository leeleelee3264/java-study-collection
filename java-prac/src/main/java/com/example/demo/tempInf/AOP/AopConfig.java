package com.example.demo.tempInf.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
@Component
@Aspect
public class AopConfig {

    // around 에서 기능을 적용할 애들을 지정하는 방법은 그냥 쓰는 exec, annotation, bean 등이 있디.
//    @Around("execution(* com.example..*.AopService.*(..))")
    @Around("@annotation(com.example.demo.tempInf.AOP.AopAnno)")
    public Object allTimeAopLogging(ProceedingJoinPoint pip) throws Throwable {
        long begin = System.currentTimeMillis();

        // 이 부분이 바로 실행하는 메소드를 가져오는 부분이다.
        Object retVal = pip.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        // 할 일을 다 하고 메소드를 리턴해준다.
        return retVal;
    }

    // around는 정말 둘러싼 형태라서 약간 그랜드한 느낌이 든다면 before, after 로 해도 되는데 얘는 메소드를 안 돌려주는 형태네..
    @Before("execution(* com.example..*.AopService.*(..))")
    public void simpleTimeAopLogging() throws Throwable {
        System.out.println("AopConfig.simpleTimeAopLogging");
    }
}
