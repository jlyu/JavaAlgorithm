package CodingRush._58_String_Reverse;

public class StringReverse {

    private void reverse(char[] chs, int begin, int end) {
        char tmp;
        while (begin <= end) {
            tmp = chs[end];
            chs[end] = chs[begin];
            chs[begin] = tmp;
            begin += 1;
            end -= 1;
        }
    }

    public String reverseSentence(String str) {
        if (str.trim().length() == 0 || str == null) { return str; }

        char[] reverseChs = str.toCharArray();
        reverse(reverseChs, 0, reverseChs.length - 1);
        String reverseStr = String.valueOf(reverseChs);

        StringBuffer sb = new StringBuffer();
        String[] reverseStrWords = reverseStr.split(" ");
        for (int i = 0; i < reverseStrWords.length; i++) {
            char[] tmp = reverseStrWords[i].toCharArray();
            reverse(tmp, 0, tmp.length - 1);
            sb.append(String.valueOf(tmp));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String leftRotateString(String str, int n) {
        if (str.trim().length() == 0 || str == null) { return str; }
        char[] chs = str.toCharArray();
        reverse(chs, 0, n - 1);
        reverse(chs, n, str.length() - 1);
        reverse(chs, 0, str.length() - 1);

        return String.valueOf(chs);
    }

    void unitTest1() {
        System.out.println(reverseSentence("I am a student."));
    }

    void unitTest2() {
        System.out.println(leftRotateString("abcdefg", 2));
    }

    public static void main(String[] args) {
        StringReverse sr = new StringReverse();
        sr.unitTest1();
        sr.unitTest2();
    }

}
