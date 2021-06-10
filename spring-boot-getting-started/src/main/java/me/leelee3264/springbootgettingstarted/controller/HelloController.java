package me.leelee3264.springbootgettingstarted.controller;

import me.leelee3264.springbootgettingstarted.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final HelloService helloService;
    private final Logger log = LoggerFactory.getLogger(HelloController.class);

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String getHello() {
        log.info("############ hello called ############");
        System.out.println("sout work");
        return "hello" + helloService.getName();
    }
}
