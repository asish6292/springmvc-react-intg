package com.akm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String forward() {
        // Forward non-API requests to React app's index.html
    	System.out.println("************home controller loaded");
        return "index.html";
    }
}

