package me.leelee3264.springbootgettingstarted.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-28
 * description
 */
@Component
public class ArgsPrint {

    public ArgsPrint(ApplicationArguments args) {
        System.out.println("VM FOO: " + args.containsOption("foo"));
        System.out.println("ARGS BAR: " + args.containsOption("bar"));
    }
}
