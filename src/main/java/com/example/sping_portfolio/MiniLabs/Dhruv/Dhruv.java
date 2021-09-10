package com.example.sping_portfolio.MiniLabs.Dhruv;
import java.util.Scanner ;

public class Dhruv {
    public static void main(String[] args) {
        double avg12 , avg34 , final_average;
        Scanner keyboard = new Scanner (System.in);
        //comment1111
        System.out.println ("Please enter the first grade:");
        double grade1 = keyboard.nextInt() ;
        System.out.println("Please enter the second grade:");
        double grade2 = keyboard.nextInt();
        System.out.println ("Please enter the third grade:");
        double grade3 = keyboard.nextInt() ;
        System.out.println("Please enter the fourth grade:");
        double grade4 = keyboard.nextInt();
        System.out.println("Please enter the fifth grade:");
        double grade5 = keyboard.nextInt();
        avg12 = ((double)grade1+grade2)/2;
        avg34 = ((double)grade3+grade4)/2;
        final_average = (avg12+avg34+grade5)/3;
        System.out.println("Your grade average is: " + final_average);
    }
}