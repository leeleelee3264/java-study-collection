package me.leelee3264.springbootgettingstarted.controller;

import me.leelee3264.springbootgettingstarted.service.HelloService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-09
 * description
 */
@RunWith(SpringRunner.class)
//이 어노테이션이 어마어마하게 무겁다. 실제 서버가 올라롤 때 처럼 등록된 빈들을 다 싹싹 긁어다가
//컨테이너에 등록을 해주고 등등 진짜 서버 올라가는 것처럼 행동을 함.
//이런 무거운 테스트가 싫다, 내가 원하는 부분만 테스트 하고 싶다 -> 이걸 슬라이스 테스트라고 한다
//@SpringBootTest

//이 어노테이션은 딱 서블릿이랑 컨트롤러 단에만 연관이 있는 기본 컴포넌트들을 이용한다
//서비스, 리파지토리, 컨피규어 아무것도 안 가져오기 때문에 필요하면 다 목빈으로 만들어 줘야 한다.
@WebMvcTest(HelloController.class)
public class HelloControllerTestSlice {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HelloService mockHelloService;


    // 얘는 테스트 진행하면서 콘솔에 찍히는 아웃풋을 다 캡쳐하는 애라고 함.
    // 로그들이 어디까지 찍혔는지 어디서 죽었는지 정도를 볼 수 있을 것 같음. 아주 간단한 용도
    @Rule
    public OutputCaptureRule out = new OutputCaptureRule();

    @Test
    public void hello() throws Exception {
        Mockito.when(mockHelloService.getName()).thenReturn(" seungmin");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello seungmin"))
                .andDo(print());

        assertThat(out.toString())
                .contains("called")
                .contains("sout");
    }

}
