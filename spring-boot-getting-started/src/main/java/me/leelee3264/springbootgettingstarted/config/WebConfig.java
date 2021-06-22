package me.leelee3264.springbootgettingstarted.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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


    // 기본적으로 존재하는 리소스 위치 말고도
    // 내가 추가해서 사용하는 리소스들의 위치를 핸들러에 표기해준다. <추가>의 개념인것
    // 근데 스프링이 관리 안 해줘서 캐쉬나 이런거 설정 셀프로 해줘야 함

//    <script th:src="@{/hello.js}"></script>
//    <script th:src="@{/leelee/hello.js}"></script>
//    템플릿에서도 leelee에 들어있는 정적 리소스에 접근을 하려면 webconfig에서 leelee 디렉터리에 대해 설정을 해줘야 한다
//            외부에서 static url 치고 들어오는 것만 해당되는게 아니었음
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // leelee 요청이 들어오면
        registry.addResourceHandler("/leelee/**")
                // 그 파일 관련된 위치는 여기다
                .addResourceLocations("classpath:/leelee/")
                .setCachePeriod(20);
    }



    // cross origin configuration 으로 편하게 설정하기
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 아 내가 원한 형태는 멀티플한 리소스 패스랑 멀티플한 오리진들인데
//        패쓰에 따라 오리진들 설정을 하나씩 해줄 수는 없고 뭉탱이로 해야 하나봄
//                얘를 들어 크로스 해야 하는 애들은 프리픽스를 똑같이주고 /api/** 이런 형식으로 와일드 카드로 다 줘버리고
//     오리진도 그냥 allowOrigins에서 나열임
        registry.addMapping("/hey")
                .allowedOrigins("http://localhost:18080", "http://localhost:8081");
    }
}
