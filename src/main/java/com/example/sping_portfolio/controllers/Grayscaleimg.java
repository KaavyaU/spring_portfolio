package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import com.example.sping_portfolio.MiniLabs.Christopher.ImageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Grayscaleimg {
    @GetMapping("/grayscaleimg")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String greeting(Model model) {
        List<ImageInfo> lii = new ArrayList<>();

        String web_server = "http://localhost:8080";

        String file0 = web_server + "/images/rgb_1.jpg";
        lii.add(new ImageInfo(file0, new String("Vincent van Gogh"), new String("The Starry Night, 1889")));

        String file1 = web_server + "/images/rgb_2.jpg";
        lii.add(new ImageInfo(file1, new String("Johannes Vermeer"), new String("Girl with a Pearl Earring, 1665")));

        String file2 = web_server + "/images/rgb_3.jpg";
        lii.add(new ImageInfo(file2, new String("James Abbott McNeill Whistler"), new String("Arrangement in Grey and Black No. 1, 1871")));

        String file3 = web_server + "/images/rgb_4.jpg";
        lii.add(new ImageInfo(file3, new String("Gustav Klimt"), new String("The Kiss, 1907–1908")));

        String file4 = web_server + "/images/rgb_5.jpg";
        lii.add(new ImageInfo(file4, new String("Jan van Eyck"), new String("The Arnolfini Portrait, 1434")));

        String file5 = web_server + "/images/rgb_6.jpg";
        lii.add(new ImageInfo(file5, new String("Georges Seurat"), new String("A Sunday Afternoon on the Island of La Grande Jatte, 1884–1886")));

        String file6 = web_server + "/images/rgb_7.jpg";
        lii.add(new ImageInfo(file6, new String("Pieter Bruegel the Elder"), new String("The Harvesters, 1565")));

        String file7 = web_server + "/images/rgb_8.jpg";
        lii.add(new ImageInfo(file7, new String("Piet Mondrian"), new String("Composition with Red Blue and Yellow, 1930")));

        String file8 = web_server + "/images/rgb_9.jpg";
        lii.add(new ImageInfo(file8, new String("Diego Rodríguez de Silva y Velázquez"), new String("Las Meninas, or The Family of King Philip IV")));

        String file9 = web_server + "/images/rgb_10.jpg";
        lii.add(new ImageInfo(file9, new String("Claude Monet"), new String("Sunrise, 1874")));

        for (int i = 0; i < lii.size(); i++) {
            lii.get(i).read_image();
        }

        model.addAttribute("lii", lii);
        return "grayscaleimg"; // returns HTML VIEW (greeting)
    }
}
