package com.sparta.jakub.palindrome;

public class Palindrom {
   

    public static void palindrome(String parameter) {
        StringBuilder palindrome = new StringBuilder(parameter);
        palindrome.reverse();

        for (int i = 0; i < parameter.length(); i++) {
            if (parameter.charAt(i) == palindrome.charAt(i)) {

            } else {
                System.out.println("is not palindrome");
                return;
            }
        }
        System.out.println("is palindrome");
    }
}
