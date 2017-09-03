package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by roshane on 9/3/17.
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String getHomePage() {
        System.out.println(">> index page");
        return "index";
    }
}
