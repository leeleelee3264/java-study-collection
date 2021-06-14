package me.leelee3264.springbootgettingstarted.byfunc.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-14
 * description
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {


    @Autowired
    MockMvc mockMvc;


    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"seungmin\", \"password\":\"123\"}";

        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                // accept의 의미는 나는 응답으로 제이슨을 원한다
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))

                .andExpect(status().isOk())
                // 이게 예전에 봤던 테스트에 쓰이는 제이슨 형식 어쩌구인것 같다
                .andExpect(jsonPath("$.username", is(equalTo("seungmin"))))
                .andExpect(jsonPath("$.password", is(equalTo("123"))));
    }


    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{\"username\":\"seungmin\", \"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                // accept의 의미는 나는 응답으로 제이슨을 원한다
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))

                .andExpect(status().isOk())
                .andExpect(xpath("/User/username")
                        .string("seungmin"))
                .andExpect(xpath("/User/password")
                        .string("123"))
                .andDo(print());

    }

}