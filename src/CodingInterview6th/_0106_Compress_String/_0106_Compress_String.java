package CodingInterview6th._0106_Compress_String;
/*
Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).

Example 1:

Input: "aabcccccaaa"
Output: "a2b1c5a3"
Example 2:

Input: "abbccd"
Output: "abbccd"
Explanation:
The compressed string is "a1b2c2d1", which is longer than the original string.
 

Note:

0 <= S.length <= 50000


https://leetcode-cn.com/problems/compress-string-lcci

 */
public class _0106_Compress_String {
    public String compressString(String S) {
        int l = S.length();
        if (l <= 2) { return S; }

        StringBuffer sb = new StringBuffer().append(S.charAt(0));
        int counter = 1;
        for (int i = 1; i < l; i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                counter += 1;
            } else {
                sb.append(counter).append(S.charAt(i));
                counter = 1;
            }
        }
        sb.append(counter);
        return (sb.toString().length() < l) ? sb.toString() : S;
    }

    public void unittest1() {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("aabcccccaaae"));
        System.out.println(compressString("abbccd"));
        System.out.println(compressString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(compressString(""));
    }

    public static void main(String[] args) {
        _0106_Compress_String a = new _0106_Compress_String();
        a.unittest1();
    }
}
