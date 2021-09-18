package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Addleader {
    @GetMapping("/addleader")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String addleader(
            @RequestParam(name="name", required=true, defaultValue="Your Name") String name,
            @RequestParam(name="count", required=true, defaultValue="0") String count,
            Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("nameout", name ); // MODEL is passed to html
        model.addAttribute("countout", count + " bottles"); // MODEL is passed to html

        return "addleader"; // returns HTML VIEW (greeting)
    }
}
