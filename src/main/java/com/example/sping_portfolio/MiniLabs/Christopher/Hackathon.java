package com.example.sping_portfolio.MiniLabs.Christopher;

import java.util.Scanner;

    public class Hackathon {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the first grade in the first bracket");
            double grade1 = scanner.nextDouble();
            System.out.println("now please enter the second grade");
            double grade2 = scanner.nextDouble();
            double firstaverage = (grade1 + grade2) / 2;
            System.out.println("the average of these two grades is: ");
            System.out.println(firstaverage);
            System.out.println("now for the second bracket of grades, please enter the first grade");
            double grade3 = scanner.nextDouble();
            System.out.println("now, enter the last grade");
            double grade4 = scanner.nextDouble();
            double secondaverage = (grade3 + grade4) / 2;
            System.out.println("the average for the second two grades is:");
            System.out.println(secondaverage);
            double finalaverage = (firstaverage+secondaverage)/2;
            System.out.println("The average of the two grading brackets is:");
            System.out.println(finalaverage);
        }
    }

