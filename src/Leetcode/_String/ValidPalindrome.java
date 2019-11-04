/*  Easy 125. Valid Palindrome
https://www.cnblogs.com/ericli-ericli/p/7753954.html

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

        Input: "A man, a plan, a canal: Panama"
        Output: true

Example 2:

        Input: "race a car"
        Output: false*/



package Leetcode.string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        String ns = s.replaceAll("[^0-9a-zA-Z]+", "").toLowerCase();
        int left = 0;
        int right = ns.length() - 1;

        while (left <= right) {
            if (ns.charAt(left) != ns.charAt(right)) { return false;}
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome ins = new ValidPalindrome();
        System.out.println( ins.isPalindrome("A man, a plan, a canal: Panama") );
        System.out.println( ins.isPalindrome("race a car") );
        System.out.println( ins.isPalindrome("") );
        System.out.println( ins.isPalindrome(" ") );
        System.out.println( ins.isPalindrome("OP") );
    }


}
