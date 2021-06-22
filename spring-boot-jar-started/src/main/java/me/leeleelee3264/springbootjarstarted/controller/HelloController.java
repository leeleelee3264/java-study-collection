package me.leeleelee3264.springbootjarstarted.controller;

import org.springframework.boot.autoconfigure.session.NonUniqueSessionRepositoryException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author SeungminLee
 * project spring-boot-jar-started
 * date 2021-06-23
 * description
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        throw new NullPointerException();
    }
}
