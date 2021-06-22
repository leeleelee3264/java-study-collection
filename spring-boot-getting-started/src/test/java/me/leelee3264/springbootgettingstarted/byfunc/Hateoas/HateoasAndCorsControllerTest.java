package me.leelee3264.springbootgettingstarted.byfunc.Hateoas;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-23
 * description
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HateoasAndCorsController.class)
public class HateoasAndCorsControllerTest {

    @Autowired
    MockMvc mockMvc;


    // 스프링 웹에 들어있어서 주입만 하면 쓸 수 있는 ObjectMapper
    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void greeting() throws Exception {
        mockMvc.perform(get("/hey"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self").exists());
    }
}