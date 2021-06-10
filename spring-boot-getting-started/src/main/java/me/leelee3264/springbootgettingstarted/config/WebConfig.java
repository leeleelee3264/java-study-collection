package me.leelee3264.springbootgettingstarted.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-11
 * description: 스프링 mvc 확장하기~ 여기서 인터셉터를 등록하거나 포멧터를 추가하거나 기타 등등 확장을 할 수 있따
 */
@Configuration
// 이제 이걸 쓰면 하나하나 다 mvc 설정을 해줘야 하는 거다
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
}
