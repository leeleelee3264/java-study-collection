package me.leelee3264.springbootgettingstarted.service.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-11
 * description
 */
@Service
@Order(1)
public class FirstOrder {

    Logger log = LoggerFactory.getLogger(FirstOrder.class);

    @PostConstruct
    public void init() {
        log.info("################################ first order #####################################");
    }
}
