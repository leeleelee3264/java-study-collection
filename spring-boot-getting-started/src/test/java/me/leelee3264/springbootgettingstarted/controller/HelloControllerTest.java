package me.leelee3264.springbootgettingstarted.controller;

import me.leelee3264.springbootgettingstarted.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-08
 * description: 테스트인데 랜덤포트 뜨는 거
 */

// 랜덤포트로 띄우면 정식으로 띄운 포트가 살아있어도 충돌이 나지 않아
//    일반서버랑 테스트 서버 동시에 띄울 수 있다는 장점이 있네
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    WebTestClient webTestClient;

    // 컨트롤러 단만 테스트 하고 싶을떄는 MockBean을 써서 가라로 컴포넌트를 만든다.
    // 이렇게 목빈을 쓰면 테스트에서 이 컴포넌트를 호출할 때 어떻게 동작을 할 것인지 내가 코딩으로 지정해 줄 수 있다
    // 말 그대로 이 컴포넌트의 동작을 흉내내는 것
    @MockBean
    HelloService mockHelloService;


    @Test
    public void hello() {
        // Mockbean을 사용해서 마치 HelloService의 getName()이 호출된 것처럼 보인다
        // 호출이 된다면 어떻게 동작할것인지 내가 가라로 만듬
        Mockito.when(mockHelloService.getName()).thenReturn(" mock seungmin");

        String rst = testRestTemplate.getForObject("/hello", String.class);
        assertThat(rst).isEqualTo("hello mock seungmin");
    }

    @Test
    public void helloWebClient() {
        Mockito.when(mockHelloService.getName()).thenReturn(" mock seungmin");

        // 요청량이 많아질때는 webclient를 쓰는게 이득이라고 한다 어지간하면 WebClient 써야할듯.
        // 비동기 처리가 되가는 하는데... 자꾸 응답을 씹고 다음 요청을 보내서 어떻게 해야 할지..
        webTestClient.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello mock seungmin");
    }
}
