package me.leelee3264.springbootgettingstarted.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-07
 * description
 */
@Configuration
@Profile("second")
public class SecondConfig {


    @Bean
    public String hello() {
        return "hello from second";
    }
}
