package CodingRush._20_String_IsNumberic;

import java.util.Arrays;

public class IsNumbericV2 {

    private String str;

    private boolean scanUnsignedInteger() {

        final int n = str.length();
        int i = 0;
        while (i < n && (str.charAt(i) >= '0' && str.charAt(i) <= '9') ) {
             i += 1;
        }
        if (i > 0) {
            str = str.substring(i, n);
            return true;
        }
        return false;
    }

    private boolean scanInteger() {
        if (str == null || str.length() == 0) { return false; }

        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            str = str.substring(1, str.length());
        }
        return scanUnsignedInteger();
    }

    public boolean isNumberic(String s) {
        this.str = s;
        final int n = str.length();
        if (n == 0) { return false; }

        boolean isNum = scanInteger();

        if (str.length() > 0 && str.charAt(0) == '.') {
            str = str.substring(1, str.length());
            isNum = scanUnsignedInteger() && isNum;
        }

        if (str.length() > 0 && (str.charAt(0) == 'E' || str.charAt(0) == 'e') ) {
            str = str.substring(1, str.length());
            isNum = scanInteger() && isNum;
        }


        return isNum && str.length() == 0;
    }

    public static void main(String[] args) {
        IsNumbericV2 i = new IsNumbericV2();
        String[] ss = {
                //true
                //"+100",
                "5e2",
                "-123",
                "3.1416",
                "-1E-16",
                //false
                "12e",
                "1a3.14",
                "1.2.3",
                "+-5",
                "12e+5.4"
        };

        for (String str: ss) {
            System.out.println( i.isNumberic(str) );
        }

    }
}
