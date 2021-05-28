package me.leelee3264.springbootgettingstarted.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-28
 * description
 */
@Component
public class AfterListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("===================================================");
        System.out.println("APPLICATION IS FULLY RUNNING");
        System.out.println("===================================================");
    }
}
