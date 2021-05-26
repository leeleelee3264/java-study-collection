package me.leelee3264.springbootgettingstarted.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-25
 * description
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }
}
