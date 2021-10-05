package com.example.sping_portfolio.MiniLabs.Kaavya;

public class Unit5Palindrome {
    public void isPalindrome (String userWord){
        String word = userWord.toLowerCase();
        String palindrome = "";
        for (int i = word.length(); i >= 0; i--){
            palindrome += word.substring(i-1, i);
        }
        System.out.println (word + " --> " + palindrome);
        boolean isPalindrome = word.equals(palindrome);
        if (isPalindrome){
            System.out.println("Is a palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }
    }
    public static void Main (String args[]) {
        Unit5Palindrome myPalindrome = new Unit5Palindrome();
        myPalindrome.isPalindrome("pop");
        myPalindrome.isPalindrome("cat");
    }
}
