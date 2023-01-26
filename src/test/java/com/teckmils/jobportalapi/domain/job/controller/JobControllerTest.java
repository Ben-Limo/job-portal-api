package com.teckmils.jobportalapi.domain.job.controller;

import com.teckmils.jobportalapi.config.SecurityConfig;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JobController.class)
@Import(SecurityConfig.class)
class JobControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithMockUser
    void testGetJobs_AuthorizedUsersCanAccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/jobs"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void testGetJobs_UnAuthorizedUsersCanAccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/jobs"))
                .andExpect(status().isOk());
    }
}