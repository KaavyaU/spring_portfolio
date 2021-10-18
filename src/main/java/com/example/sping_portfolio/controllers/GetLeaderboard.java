package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.LeaderboardRepository;
import com.example.sping_portfolio.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class GetLeaderboard {
    @Autowired
    private LeaderboardRepository repo;

    @GetMapping("/leaderboard")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getLeaderboard(
        @RequestParam(name="name", required=true, defaultValue="Your Name") String name,
        @RequestParam(name="count", required=true, defaultValue="0") String count,
        Model model) {
        Participant userDetails;
        userDetails = repo.findByRank(3);
            // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
            model.addAttribute("rankout", userDetails.getRank());
            model.addAttribute("nameout", userDetails.getUsername() ); // MODEL is passed to html
            model.addAttribute("countout", userDetails.getAmtRecycled() + " items"); // MODEL is passed to html
            return "leaderboard"; // returns HTML VIEW (greeting)
    }
}

