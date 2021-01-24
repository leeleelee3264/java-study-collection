package com.example.demo.Controller;

import com.example.demo.tempInf.BeanValid.MessageDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
public class ApiControllerTest extends ControllerTestFrame {

    @Autowired
    private ApiController apiController;

    @Override
    protected Object controller() {
        return apiController;
    }

    @Test
    public void beanValid() throws Exception {

        MessageDTO user = new MessageDTO(1, "", "434", "r3r3r");

        mockMvc.perform(post("/api/bean/valid")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(user)));
    }
}
