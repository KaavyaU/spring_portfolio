package com.example.sping_portfolio.MiniLabs.Jacqueline;

public class Hackathon {
    public static void main(String[] args) {
        String student = "Jacqueline";
        int score1 = 75;
        int score2 = 85;
        double average1 = (score1 + score2)/2;
        System.out.println("The average of first two test is " + average1);
        int score3 = 93;
        int score4 = 81;
        double average2 = (score3 + score4)/2;
        System.out.println("The average of third and fourth test is " + average2);
        int score5 = 90;
        double totalaverage = (average1 + average2 + score5)/3;
        System.out.println("The total average of " + student + "'s five test is " + totalaverage );
    }
}
