package me.leelee3264.springbootgettingstarted.listener;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-24
 * description: ServletWebServerInitializedEvent 얘는 서버가 뜨자마자 작동이 되는 이벤트 리스너다
 * 서버 뜨자마자 포트 번호를 가져올 것임
 */
@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {


    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent servletWebServerInitializedEvent) {

        // 역시 포트 같은 어플리케이션에 밀접한 정보를 가져오려면 컨텍스트를 써야 하나봄
        ServletWebServerApplicationContext applicationContext = servletWebServerInitializedEvent.getApplicationContext();
        System.out.println(applicationContext.getWebServer().getPort());
    }
}
