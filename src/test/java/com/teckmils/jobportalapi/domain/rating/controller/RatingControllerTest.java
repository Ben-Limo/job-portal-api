package com.teckmils.jobportalapi.domain.rating.controller;

import com.teckmils.jobportalapi.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(RatingController.class)
@Import(SecurityConfig.class)
class RatingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithMockUser
    void testGetRating_OnlyAuthorizedUsersCanAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rating"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void testGetRating_UnAuthorizedUsersCannotAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rating"))
                .andExpect(status().isUnauthorized());
    }
}