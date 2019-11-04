/*67. Add Binary   https://leetcode.com/problems/add-binary/   Easy

* Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

    Input: a = "11", b = "1"
    Output: "100"

Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"
*/

package Leetcode.string;

public class AddBinary {
    public String addBinary(String a, String b) {
        final int na = a.length();
        final int nb = b.length();

        String s1   = (na > nb) ? a : b;
        String s2 = (na > nb) ? b : a;
        final int n1 = s1.length();
        final int n2 = s2.length();
        final int diff = n1 - n2;

        boolean carry = false;
        char[] bits = new char[Math.max(n1, n2) + 1];
        for (int i = Math.max(n1, n2) - 1; i >= 0; i--) {

            char c1 = s1.charAt(i);
            char c2 = (i-diff >= 0) ? s2.charAt(i-diff) : '0';
            int s = c1 + c2; // '2' = 98, '0' = 96

            if (s == 98) {
                bits[i+1] = (carry) ? '1' : '0';
                carry = true;
            } else if (s == 97) {
                bits[i+1] = (carry) ? '0' : '1';
            } else {
                bits[i+1] = (carry) ? '1' : '0';
                carry = false;
            }
        }
        bits[0] = (carry) ? '1' : '0';
        return (carry) ? String.valueOf(bits) : (String.valueOf(bits)).substring(1);
    }

    public static void main(String[] args) {
        AddBinary ins = new AddBinary();
        System.out.println(ins.addBinary("0", "0"));
        System.out.println(ins.addBinary("0", "1"));
        System.out.println(ins.addBinary("1", "1"));
        System.out.println(ins.addBinary("11", "1"));
        System.out.println(ins.addBinary("1010", "1011"));
        System.out.println(ins.addBinary("1111100001101", "11011110011"));
        System.out.println(ins.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                                     "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
