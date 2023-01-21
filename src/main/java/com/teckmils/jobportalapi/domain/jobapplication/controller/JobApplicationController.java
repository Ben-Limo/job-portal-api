package com.teckmils.jobportalapi.domain.jobapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobApplicationController {
    @GetMapping("/applications")
    public String getJobApplication() {
        return "list of job application";
    }
}
