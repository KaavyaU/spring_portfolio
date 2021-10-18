package com.example.sping_portfolio.Minilabs.Dhruv;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import com.example.sping_portfolio.MiniLabs.Christopher.ImageInfo;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

//@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Grayscaleimg {
    //@GetMapping("/grayscaleimg")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String greeting(Model model) {
        List<ImageInfo> lii = new ArrayList<>();

        String web_server = "http://localhost:8080";

        /*
        String [] images = {"/images/rgb_1.jpg", "/images/rgb_2.jpg", “/images/rgb_4.jpg", "/images/rgb_5.jpg", "/images/rgb_6.jpg", "/images/rgb_7.jpg", "/images/rgb_8.jpg", "/images/rgb_9.jpg", "/images/rgb_10.jpg"}
        String [] artist = {“Vincent van Gogh", "Johannes Vermeer", "James Abbott McNeill Whistler", "Gustav Klimt", "Jan van Eyck", "Georges Seurat", "Pieter Bruegel the Elder", "Piet Mondrian", "Diego Rodríguez de Silva y Velázquez", "Claude Monet" ))}
        String [] title = {“The Starry Night, 1889", "Girl with a Pearl Earring, 1665, "Arrangement in Grey and Black No. 1, 1871", "The Kiss, 1907–1908", "The Arnolfini Portrait, 1434", "A Sunday Afternoon on the Island of La Grande Jatte, 1884–1886", "The Harvesters, 1565", "Composition with Red Blue and Yellow, 1930", "Las Meninas, or The Family of King Philip IV", "Sunrise, 1874""}
        for(int i=0; i <  images.length ; i++){
            lii.add(new ImageInfo(web_server + images.get[i], artist.get[i], title.get[i]);


            lii.get(i).read_image();
        }

         */

            model.addAttribute("lii", lii);
        return "grayscaleimg"; // returns HTML VIEW (greeting)
    }

}