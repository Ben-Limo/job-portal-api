package com.teckmils.jobportalapi.domain.rating.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
    @GetMapping("/rating")
    public String getRating() {
        return "Here is the rating";
    }
}
