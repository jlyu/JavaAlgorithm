package CodingRush._48_String_LongestSubStringNoRepeat;

public class LongestSubStringNoRepeat {

    public int longSubStringNoRepeat(String str) {
        int currentLength = 0;
        int maxLength = 0x80000000;
        int[] positions = new int[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int pIndex = positions[str.charAt(i) - 'a'];
            if (pIndex < 0 || i - pIndex > currentLength) {
                currentLength += 1;
            }
            else {
                maxLength = (currentLength > maxLength) ? currentLength : maxLength;
                currentLength = i - pIndex;
            }
            positions[str.charAt(i) - 'a'] = i;
            maxLength = (currentLength > maxLength) ? currentLength : maxLength;
        }
        return maxLength;
    }

    void unitTest1() {
        System.out.println(longSubStringNoRepeat("arabcacfr"));
    }

    public static void main(String[] args) {
        LongestSubStringNoRepeat l = new LongestSubStringNoRepeat();
        l.unitTest1();
    }
}
