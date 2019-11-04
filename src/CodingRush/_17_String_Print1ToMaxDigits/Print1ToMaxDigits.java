package CodingRush._17_String_Print1ToMaxDigits;

public class Print1ToMaxDigits {
    public void printNumber(char[] chs) {
        boolean isLeading0 = true;
        final int chsSize = chs.length;

        for (int i = 0; i < chsSize; i++) {
            if (isLeading0 && chs[i] != '0') {
                isLeading0 = false;
            }

            if (!isLeading0) {
                System.out.print(chs[i]);
            }
        }
        System.out.println();
    }

    public void printResursively(char[] chs, int length, int index) {
        if (index == length - 1) {
            printNumber(chs);
            return;
        }

        for (int i = 0; i < 10; i++) {
            chs[index + 1] = (char)(i + 48);
            printResursively(chs, length, index + 1);
        }
    }

    public void print(int n) {
        if (n <= 0) { return; }

        char[] chs = new char[n];
        for (int i = 0; i < 10; i++) {
            chs[0] = (char)(i + 48);
            printResursively(chs, n, 0);
        }
    }

    void unitTest1() {
        print(3);
    }

    public static void main(String[] args) {
        Print1ToMaxDigits p = new Print1ToMaxDigits();
        p.unitTest1();
    }
}
