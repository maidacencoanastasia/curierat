package com.curierat.curier.controller;

import com.curierat.curier.repository.ComandRepositoriu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    private ComandRepositoriu comandRepositoriu;
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
