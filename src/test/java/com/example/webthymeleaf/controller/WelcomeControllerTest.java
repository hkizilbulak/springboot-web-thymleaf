package com.example.webthymeleaf.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = WelcomeController.class)
public class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    List<String> tasks = Arrays.asList("a","b","c","d","e","f","g");

    @Test
    public void main() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("message",equalTo("Hello World")))
                .andExpect(model().attribute("tasks", is(tasks)))
                .andExpect(content().string(containsString("Hello, Hello World")));
    }

    @Test
    public void mainWithParam() throws Exception {
        mockMvc.perform(get("/hello").param("name","huseyin"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("message", equalTo("huseyin")))
                .andExpect(content().string(containsString("Hello, huseyin")));
    }

}