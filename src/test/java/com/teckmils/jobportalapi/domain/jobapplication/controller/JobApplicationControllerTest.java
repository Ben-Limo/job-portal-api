package com.teckmils.jobportalapi.domain.jobapplication.controller;

import com.teckmils.jobportalapi.config.SecurityConfig;
import com.teckmils.jobportalapi.domain.job.controller.JobController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class JobApplicationControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    void applicationsWhenUnAuthenticatedUserReturns401() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/applications"))
                .andExpect(status().isUnauthorized());

    }

    @Test
    void applicationsReturnsListOfJobApplications() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/applications")
                        .with(user("mockUser")))
                .andExpect(status().isOk())
                .andExpect(content().string("list of job application"));

    }
}