package me.leelee3264.springbootgettingstarted.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-28
 * description
 */
@Component
public class RunnerWIthApplicationRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=============== First Runner run =================");
        System.out.println("VM FOO: " + args.containsOption("foo"));
        System.out.println("ARGS BAR: " + args.containsOption("bar"));
    }
}
