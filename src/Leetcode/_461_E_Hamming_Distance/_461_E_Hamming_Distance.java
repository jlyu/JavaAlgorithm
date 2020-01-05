package Leetcode._461_E_Hamming_Distance;
/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.


https://leetcode-cn.com/problems/hamming-distance
 */
public class _461_E_Hamming_Distance {
    public int hammingDistance_(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor != 0) {
            res++;
            xor = xor & (xor - 1);
        }
        return res;
    }
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public void unittest1() {
        System.out.println(hammingDistance(1,4));
    }

    public static void main(String[] args) {
        _461_E_Hamming_Distance a = new _461_E_Hamming_Distance();
        a.unittest1();
    }
}
