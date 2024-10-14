package com.akm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String forward() {
        // Forward non-API requests to React app's index.html
        return "forward:/index.html";
    }
}

