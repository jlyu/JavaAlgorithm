package CodingRush._46_String_GetTranslationCount;

public class GetTranslationCount {
    public int getTranslationCount(int n) {
        if (n < 0) { return 0; }
        String str = Integer.toString(n);
        final int strLen = str.length();
        int[] counts = new int[strLen];
        int count = 1;

        for (int i = strLen - 1; i >= 0; i--) {
            count = (i < strLen - 1) ? counts[i+1] : 1;

            if (i < strLen - 1) {
                int d1 = str.charAt(i) - '0';
                int d2 = str.charAt(i + 1) - '0';
                int num = d1 * 10 + d2;
                if (num >= 10 && num <= 25) {
                    count = (i < strLen - 2) ? (count + counts[i+2]) : (count + 1);
                }

            }
            counts[i] = count;
        }

        return counts[0];
    }

    void unitTest1() {
        System.out.println(getTranslationCount(12258));
    }

    public static void main(String[] args) {
        GetTranslationCount g = new GetTranslationCount();
        g.unitTest1();
    }
}
