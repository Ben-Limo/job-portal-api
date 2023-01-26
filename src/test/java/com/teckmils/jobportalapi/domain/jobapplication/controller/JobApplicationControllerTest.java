package com.teckmils.jobportalapi.domain.jobapplication.controller;

import com.teckmils.jobportalapi.config.SecurityConfig;
import com.teckmils.jobportalapi.domain.job.controller.JobController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JobApplicationController.class)
@Import(SecurityConfig.class)
class JobApplicationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithAnonymousUser
    void testGetJobApplication_UnAuthorizedUsersCannotAccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/applications"))
                .andExpect(status().isUnauthorized());

    }

    @Test
    @WithMockUser
    void testGetJobApplication_OnlyAuthorizedUsersCanAccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/applications"))
                .andExpect(status().isOk());

    }
}