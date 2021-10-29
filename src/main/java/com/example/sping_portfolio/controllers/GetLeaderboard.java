package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.LeaderboardRepository;
import com.example.sping_portfolio.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

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
        ArrayList<Participant> participants = getParticipants();
            // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
            model.addAttribute("participantsout", participants);
            return "leaderboard"; // returns HTML VIEW (greeting)
    }
    public ArrayList<Participant> getParticipants(){
        ArrayList <Participant> participantList = new ArrayList<Participant>();
        for (int x=1; x <= 3; x++){
            participantList.add(repo.findByRank(x));
        }
        return participantList;
    }
}

