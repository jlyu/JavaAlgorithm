package CodingRush._05_String_ReplaceBlank;

public class ReplaceBlank {

    public String replaceBlank(String str) {
        final int n = str.length();
        if (n <= 0) { return str; }

        int blankCounter = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                blankCounter++;
            }
        }

        char[] chs = new char[n + blankCounter * 2];
        int k = chs.length - 1;

        for (int j= n-1; j >= 0; j--) {
            if (str.charAt(j) == ' ') {
                chs[k--] = '0';
                chs[k--] = '2';
                chs[k--] = '%';
            }
            else {
                chs[k--] = str.charAt(j);
            }
        }
        return new String(chs);
    }

    void unitTest1() {
        System.out.println(replaceBlank("We are happy."));
    }

    public static void main(String[] args) {
        ReplaceBlank r = new ReplaceBlank();
        r.unitTest1();
    }
}
