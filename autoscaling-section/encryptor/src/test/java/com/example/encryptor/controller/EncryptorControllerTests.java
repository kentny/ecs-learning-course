package com.example.encryptor.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class EncryptorControllerTests {
    @Autowired
    private EncryptorController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.controller = new EncryptorController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldGetHelloAvailable() throws Exception {
        this.mockMvc
                .perform(get("/api/encryptor"))
                .andExpect(status().isOk());
    }
}
