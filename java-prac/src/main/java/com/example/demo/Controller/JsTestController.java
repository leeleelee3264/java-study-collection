package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SeungminLee
 * project demo
 * date 2021-01-13
 * description
 */
@Slf4j
@RequestMapping("/js")
@Controller
public class JsTestController {

    @GetMapping("/history")
    public String testHistory() {
        log.info("############ server hit! ############");
        return "historyTest";
    }
}
