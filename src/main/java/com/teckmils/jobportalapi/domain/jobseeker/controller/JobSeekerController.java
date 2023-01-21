package com.teckmils.jobportalapi.domain.jobseeker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobSeekerController {
    @GetMapping("/profile")
    public String getJobSeekerDetails() {
        return "Here is your profile";
    }
}
