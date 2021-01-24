package com.example.demo.Controller;

import com.example.demo.tempInf.BeanValid.MyExceptionHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description: MockMvc 를 이용하면 서버를 띄우지 않고 mvc 형태의 테스트를 진행 할 수 있다. controller - service - dao 다 불러내는 형태인듯
 * 그래서 사실 unit 테스트라고 볼 수 없다.
 */
@SpringBootTest
@AutoConfigureMockMvc
public abstract class ControllerTestFrame {

    protected MockMvc jsonMock;

    @Autowired
    protected ObjectMapper objectMapper;

    abstract protected Object controller();

    protected String asJsonString(final Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    @BeforeEach
    private void setup() {
        jsonMock = MockMvcBuilders.standaloneSetup(controller())
                // to bind exception with mockMvc
                .setControllerAdvice(new MyExceptionHandler())
                .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
                .alwaysDo(print())
                .build();

    }

}