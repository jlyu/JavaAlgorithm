package CodingRush._20_String_IsNumberic;

public class IsNumberic {

    private String scanUnsignedInteger(String str) {
        if (str == null || str.length() == 0) { return null; }

        final int n = str.length();
        int i = 0;
        for (; i < n; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                if (i == 0) { return null; }
                return str.substring(i, n);
            }
        }

        return str;
    }

    private String scanInteger(String str) {
        if (str == null || str.length() == 0) { return null; }
        String s = str;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            s = str.substring(1, str.length());
        }
        return scanUnsignedInteger(s);
    }

    public boolean isNumberic(String str) {
        final int n = str.length();
        if (n == 0) { return false; }


        String s1 = scanInteger(str);
        if (s1 == null || s1.length() == 0) { return false; }

        if (s1.charAt(0) == '.') {
            s1 = scanUnsignedInteger(s1.substring(1, s1.length()));
            if (s1 == null || s1.length() == 0) { return false; }
        }


        if (s1.charAt(0) == 'E' || s1.charAt(0) == 'e') {
            s1 = scanInteger(s1.substring(1, s1.length()));
            if (s1 == null || s1.length() == 0) { return false; }
        }

        s1 = scanInteger(s1);
        if (s1 == null || s1.length() == 0) { return false; }
        return true;
    }

    public static void main(String[] args) {
        IsNumberic i = new IsNumberic();
        String[] ss = {
                //true
                //"+100",
                //"5e2",
                //"-123",
                //"3.1416",
                //"-1E-16",
                //false
                //"12e",
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
