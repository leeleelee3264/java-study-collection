package com.example.demo.Units;

import com.example.demo.Controller.ApiController;
import com.example.demo.DB.DAO.UsersVO;
import com.example.demo.Service.UsersServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-24
 * description: controller unit test
 */

// @SpringBootTest 이 어노테이션을 쓰면 통합 테스트가 된다. unit 테스트에서 지향해야 함. 그리고 이건 실제 db 가 엑세스가 된다.
@ExtendWith(SpringExtension.class)
// 이 어노가 있으면 마치 ApiController 만 있는 것처럼 스프링 부트를 제한해준다.
@WebMvcTest(ApiController.class)
class ApiControllerTest {

    // 얘가 바로 full http server 시작 안 하고 controller 테스트 할 수 있게 해주는 것!
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsersServiceImp usersServiceImp;

    @Autowired
    protected ObjectMapper objectMapper;

    protected String asJsonString(final Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void givenUsersVO_whenGetUsersVO_thenReturnPOJO() throws Exception {

        UsersVO dummy = UsersVO.builder()
                .name("jamie")
                .salary(1000)
                .build();

        given(usersServiceImp.save(dummy)).willReturn(dummy);

        mvc.perform(post("/api/jpa/save")
                .content(asJsonString(dummy))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(dummy.getName())));

    }

}