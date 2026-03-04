package com.example.demo.TestCase;

import com.example.demo.Controller.UserController;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserService userService;
    @Test
    void createUser_success() throws Exception{
        User user = new User();
        user.setName("Jay");
        user.setEmail("jayWu@gmail.com");

        when(userService.addUser(any(User.class)))
                .thenReturn(user);

        String json = objectMapper.writeValueAsString(user);

        mockMvc.perform(
                post("/api/user")
                        .contentType("application/json")
                        .content(json)
        )       .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jason"))
                .andExpect(jsonPath("$.email").value("jayWu@gmail.com"));
    }
}
