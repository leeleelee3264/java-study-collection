package me.leelee3264.springbootgettingstarted;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = "my.name=testName")
@SpringBootTest(properties = "my.name=applicationName")
class SpringBootGettingStartedApplicationTests {

//    환경변수 같은 프로퍼티는 대부분 스프링 내장 클래스인 env로 뽑아온다
    @Autowired
    Environment environment;

    @Test
    void contextLoads() {
        System.out.println(environment.getProperty("my.name"));
        System.out.println(environment.getProperty("my.age"));

    }

}
