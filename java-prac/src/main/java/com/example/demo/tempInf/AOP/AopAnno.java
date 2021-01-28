package com.example.demo.tempInf.AOP;

import java.lang.annotation.*;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface AopAnno {
}
