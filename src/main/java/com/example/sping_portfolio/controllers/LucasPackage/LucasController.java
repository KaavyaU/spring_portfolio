package com.example.sping_portfolio.controllers.LucasPackage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LucasController {
    public List<LucasNumbers> calculate (int nth) {
        //Lucas objects created with different initializers
        List<LucasNumbers> lucasList = new ArrayList<>();
        lucasList.add(new LucasFor(nth));
        lucasList.add(new LucasWhile(nth));
        lucasList.add(new LucasRecurse(nth));
        lucasList.add(new LucasStream(nth));
        return lucasList;
    }
    @GetMapping("/lucas")
    public String getLucas(@RequestParam(name="seqsize", required=false,  defaultValue="20") String seqsize, Model model) {
        //nth is fibonacci request
        int nth = Integer.parseInt(seqsize);

        //MODEL attributes are passed back html
        model.addAttribute("lucasList", calculate(nth));

        return "/lucas"; //HTML render fibonacci results

    }
}
