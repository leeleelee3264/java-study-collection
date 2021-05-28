package me.leelee3264.springbootgettingstarted.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-28
 * description: event before application fully runs
 */
public class BeforeListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("===================================================");
        System.out.println("APPLICATION IS STARTING");
        System.out.println("===================================================");
    }
}
