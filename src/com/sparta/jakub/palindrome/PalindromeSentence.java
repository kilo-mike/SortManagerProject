package com.sparta.jakub.palindrome;

public class PalindromeSentence {


    public static void PalindromeSentence(String insert) {

        String sentence = insert.toLowerCase();
        sentence = sentence + " ";
        String word = "";
        String longestWord = "";
        int wordLength = 0;
        int longestPalindrome = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ') {
                word = word + sentence.charAt(i);
            } else {
                wordLength = word.length();
                if (checkPalindrome(word) && wordLength > longestPalindrome) {
                    longestWord = word;
                    longestPalindrome = wordLength;
                }
                word = "";
            }
        }
        System.out.println(longestWord);
    }

    public static boolean checkPalindrome(String insert) {
        if (insert == "") {
            return false;
        }
        String parameter = insert.toLowerCase();
        StringBuilder palindrome = new StringBuilder(parameter);
        palindrome.reverse();

        for (int i = 0; i < parameter.length(); i++) {
            if (parameter.charAt(i) == palindrome.charAt(i)) {

            } else {
                return false;
            }
        }
        return true;
    }

}

