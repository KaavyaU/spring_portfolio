package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

class LucasNumbers {
    public String while_list;
    public String for_list;
    public String rec_list;
    public String formula_list;

    int LucasNumbers_While(int term) {
        int fnumber = 2;
        int snumber = 1;
        while_list="[";

        if (term == 1) {
            while_list = while_list + fnumber + "]";
            return fnumber;
        }

        if (term == 2) {
            while_list = while_list + snumber + "]";
            return snumber;
        }

        int x = 3;
        int newnum = 0;

        while_list = while_list + fnumber + "," + snumber;

        while (x <= term){
            newnum = fnumber + snumber;
            while_list = while_list + "," + newnum;
            fnumber = snumber;
            snumber = newnum;
            x += 1;
        }

        while_list = while_list + "]";
        return newnum;
    } //end LucasNumbers_While


    int LucasNumbers_For(int term) {
        int fnumber = 2;
        int snumber = 1;
        if (term == 1) {
            return fnumber;
        }

        if (term == 2) {
            return snumber;
        }

        int newnum = 0;
        for(int x = 3; x<=term; x++){
            newnum = fnumber + snumber;
            fnumber = snumber;
            snumber = newnum;

        }
        return newnum;

    } //end LucasNumbers_For

    int LucasNumbers_Recursion(int term) {
        int fnumber = 2;
        int snumber = 1;

        if (term == 1) {
            return fnumber;
        }

        if (term == 2) {
            return snumber;
        }

        return LucasNumbers_Recursion(term-1) + LucasNumbers_Recursion(term-2);

    }

    int LucasNumbers_Formula(int term) {
        if (term == 1) {
            return 2;
        }

        if (term == 2) {
            return 1;
        }

        int n = term - 2;
        double t1, t2;
        t1 = Math.pow( (1 + Math.pow(5, 0.5))/2, (n + 1));
        t2 = Math.pow( (1 - Math.pow(5, 0.5))/2, (n + 1));
        return (int)(t1 + t2);
    }
} //end LucasNumbers


@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Algorithm {
    @GetMapping("/algorithm")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String algorithm(
            @RequestParam(name="term", required=false, defaultValue="1") String term,
            Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        String wtime;
        String wresult;
        String wlist;
        String ftime;
        String fresult;
        String rtime;
        String rresult;
        String frtime;
        String frresult;

        LucasNumbers v = new LucasNumbers();
        model.addAttribute("term", term); // MODEL is passed to html

        long startTime = System.nanoTime();
        wresult = new String( String.valueOf(v.LucasNumbers_While(Integer.parseInt(term))) );
        long endTime = System.nanoTime();
        double deltatime = (double)(endTime - startTime)/1000000.0;
        wtime = new String(String.valueOf(deltatime));
        model.addAttribute("wtime", wtime); // MODEL is passed to html
        model.addAttribute("wresult", wresult); // MODEL is passed to html
        wlist = new String(v.while_list);
        model.addAttribute("wlist", wlist); // MODEL is passed to html

         startTime = System.nanoTime();
        fresult = new String( String.valueOf(v.LucasNumbers_For(Integer.parseInt(term))) );
         endTime = System.nanoTime();
         deltatime = (double)(endTime - startTime)/1000000.0;
        ftime = new String(String.valueOf(deltatime));
        model.addAttribute("ftime", ftime); // MODEL is passed to html
        model.addAttribute("fresult", fresult); // MODEL is passed to html

         startTime = System.nanoTime();
        rresult = new String( String.valueOf(v.LucasNumbers_Recursion(Integer.parseInt(term))) );
         endTime = System.nanoTime();
         deltatime = (double)(endTime - startTime)/1000000.0;
        rtime = new String(String.valueOf(deltatime));
        model.addAttribute("rtime", rtime); // MODEL is passed to html
        model.addAttribute("rresult", rresult); // MODEL is passed to html

         startTime = System.nanoTime();
        frresult = new String( String.valueOf(v.LucasNumbers_Formula(Integer.parseInt(term))) );
         endTime = System.nanoTime();
         deltatime = (double)(endTime - startTime)/1000000.0;
        frtime = new String(String.valueOf(deltatime));
        model.addAttribute("frtime", frtime); // MODEL is passed to html
        model.addAttribute("frresult", frresult); // MODEL is passed to html


        return "algorithm"; // returns HTML VIEW (greeting)
    }
}