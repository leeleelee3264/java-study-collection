package me.leelee3264.springbootgettingstarted.controller;

import me.leelee3264.springbootgettingstarted.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-25
 * description
 */
@Controller
public class HelloController {

    private final HelloService helloService;
    private final Logger log = LoggerFactory.getLogger(HelloController.class);

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping("/hello")
    @ResponseBody
    public String getHello() {
        log.info("############ hello called ############");
        System.out.println("sout work");
        return "hello" + helloService.getName();
    }


    // 맨날 ResponseBody를 위에다가 썼는데 이렇게 옆에다가 써도 된다
//    기본으로 Controller 어노를 쓰고 @ResponseBody를 쓰지 않으면 스프링이 뷰리졸버를 쓰면서 맞는 뷰를 찾으려 해서 오류가 난다
    @GetMapping("/convert")
    public @ResponseBody int getTest(

    ) {
        return 1;
    }


    @GetMapping("/hello/page")
    public String getHelloPage() {
        return "hello";
    }
}
