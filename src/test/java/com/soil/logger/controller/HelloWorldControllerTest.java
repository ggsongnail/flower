package com.soil.logger.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest(classes = HelloWorldController.class)
@AutoConfigureMockMvc
class HelloWorldControllerTest {
    @Resource
    private MockMvc mockMvc;

    private MvcResult getMvcResult(String url, Object dto) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(url).header("Authorization", "token")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content("")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.content().string("hello world"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    private void responseResult(MvcResult mvcResult) throws Exception {
        log.debug("status: {}", mvcResult.getResponse().getStatus());
        log.debug("content: {}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    void hello() throws Exception {
        responseResult(getMvcResult("/hello",null));
    }
}