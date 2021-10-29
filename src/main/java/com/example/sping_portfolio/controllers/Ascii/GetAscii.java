package com.example.sping_portfolio.controllers.Ascii;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GetAscii {
    @GetMapping("/asciiart")
    public String asciiArt(Model model){
        System.out.println("Start Ascii Art");
        ImageInfo ascii = new ImageInfo("glassesAsciiArt.txt", "http://icons.iconarchive.com/icons/icons8/ios7/512/Very-Basic-Glasses-icon.png", 1);
        String asciiChars = ascii.asciiArt();
        System.out.println("End Ascii Art");
        System.out.println(asciiChars);
        model.addAttribute("asciiout", asciiChars);
        return "ascii";
    }
}
