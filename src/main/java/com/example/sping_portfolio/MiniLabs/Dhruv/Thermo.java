package com.example.sping_portfolio.MiniLabs.Dhruv;

public class Thermo {
        public void check_temp(int age, int temp, String name) {
            if (temp > 98) {
                System.out.println("You are sick, and need to rest");
            } else if (temp <= 98) {
                System.out.println("You are fine"); //comment
            }
        }
    }
