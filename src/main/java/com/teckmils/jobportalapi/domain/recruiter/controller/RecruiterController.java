package com.teckmils.jobportalapi.domain.recruiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecruiterController {
    @GetMapping("/recruiter")
    public String getRecruiterDetails() {
        return "Here are the recruiter details";
    }
}
