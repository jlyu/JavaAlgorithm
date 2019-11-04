/*91. Decode Ways   https://leetcode.com/problems/decode-ways/   Medium

A message containing letters from A-Z is being encoded to numbers using the following mapping:

        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

        Input: "12"
        Output: 2
        Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

        Input: "226"
        Output: 3
        Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).*/

package Leetcode.string;


import java.util.*;

public class DecodeWays {
    public int numDecodings(String s) {

        final int n = s.length();
        if (n == 0) { return 0; }
        int[] a = new int[n + 1];

        a[n] = 1;
        a[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n-2; i >= 0; i--) {
            if (s.charAt(i) == '0') { continue; }
            a[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? a[i + 1] + a[i + 2] : a[i + 1];
        }
        return a[0];
    }

    public static void main(String[] args) {
        DecodeWays ins = new DecodeWays();
        //System.out.println( ins. numDecodings("") == 0);
        //System.out.println( ins. numDecodings("0") == 0);
        //System.out.println( ins. numDecodings("00") == 0);
        //System.out.println( ins. numDecodings("10") == 1);
        //System.out.println( ins. numDecodings("1010101010101100101") );
//        System.out.println( ins. numDecodings("12") == 2);
        System.out.println( ins. numDecodings("226") == 3 );  //"BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
        System.out.println( ins. numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948") );
    }
}


/*
    public int numDecodings(String s) {
        if (s.length() == 0) { return 0; }

        List<String> lastWord = new ArrayList<String>();
        String leading = s.substring(0, 1);
        if (leading.equals("0")) { return 0; }
        lastWord.add(leading);

        final int sl = s.length();
        for (int i = 1; i < sl; i++) {
            String sc = s.substring(i, i+1);

            int listSize = lastWord.size();
            for (int j = listSize - 1; j >= 0; j--) {

                String prev = lastWord.get(j);
                if (!sc.equals("0")) {
                    lastWord.add(sc);
                }

                if (Integer.valueOf(prev + sc) <= 26) {
                    lastWord.set(j, lastWord.get(j) + sc);
                } else {
                    lastWord.remove(j);
                }
            }

        }
        return lastWord.size();
    }*/
