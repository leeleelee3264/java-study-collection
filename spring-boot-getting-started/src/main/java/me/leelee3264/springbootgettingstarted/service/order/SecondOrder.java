package me.leelee3264.springbootgettingstarted.service.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-11
 * description
 */
@Service
@Order(2)
public class SecondOrder {


    Logger log = LoggerFactory.getLogger(SecondOrder.class);

    @PostConstruct
    public void init() {
        log.info("################################ second order #####################################");
    }

}
