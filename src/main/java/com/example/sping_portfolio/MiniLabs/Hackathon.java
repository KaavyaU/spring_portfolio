package com.example.sping_portfolio.MiniLabs;

public class Hackathon {
    public static void main(String[] args) {
        String studentName = "Student";
        //set the values of all 5 tests
        int test1 = 100;
        int test2 = 95;
        int test3 = 98;
        int test4 = 90;
        int test5 = 88;
        //Find the averages from the first and second grading periods
        double Avg12 = ((double)test1 + test2) / 2;
        double Avg34 = ((double)test3 + test4) / 2;
        //Find the average of test 5 and the averages from each grading period
        double AvgAll = (Avg12 + Avg34 + test5) / 3;
        //Print out the student name and their year-long average
        System.out.println (studentName + " has an average grade of " + AvgAll);
    }
}
