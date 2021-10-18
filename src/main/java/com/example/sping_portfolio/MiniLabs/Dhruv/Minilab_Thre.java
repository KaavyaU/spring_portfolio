package com.example.sping_portfolio.MiniLabs.Dhruv;
import java.util.Scanner ;

public class Minilab_Thre {
    public static void main(String[] argsv) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = keyboard.nextInt();
        System.out.println("What is your name?");
        String name = keyboard.next();
        System.out.println("What is your temperature?");
        int temp = keyboard.nextInt();
        Thermo t = new Thermo();
        t.check_temp( age, temp, name);
    }
}


