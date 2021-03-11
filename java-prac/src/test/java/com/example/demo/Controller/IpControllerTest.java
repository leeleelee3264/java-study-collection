package com.example.demo.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author SeungminLee
 * project demo
 * date 2021-02-17
 * description
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(IpController.class)
class IpControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void ip_network() throws Exception {
        mvc.perform(post("/ip/network"));
    }

}