package me.leelee3264.springbootgettingstarted.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-08
 * description: 테스트인데 MOCK 테스트 할 것임
 */

//webenvironment가 mock이면 실제 mvc는 안 뜨고 요청 보내는 형태랑 비스무리한 목업 서블릿이 뜬다
//    목업 서블릿떠서 정식 서블릿이 안 뜨고 진짜 실제로 톰캣이 안 뜬다. 콘솔 로그 확인해보면 포트 몇몇에 떴다는 소리도 없음
//그래서 이제 mockmvc로 흉내를 내주는건데 그때 autoconfigmock을 하는 것
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class HelloControllerTestMock {


    @Autowired
    MockMvc mockMvc;


    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello leeleelee3264"))
                .andDo(print());

        // 아예 andDo로 결과를 찍을 수 있었네
        // 내가 맨날 하는 것처럼 mvcResult 받아와서 바디빼고 뭐하고 안 해도 되는 것 이었다
    }
}