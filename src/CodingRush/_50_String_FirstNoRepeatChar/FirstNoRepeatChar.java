package CodingRush._50_String_FirstNoRepeatChar;

public class FirstNoRepeatChar {
    public char firstNoRepeatChar(String str) {
        if (str.length() == 0) { return '\0'; }

        int[] hashTable = new int[26];
        for (int i = 0; i < 26; i++) {
            hashTable[i] = 0;
        }


        for (int i = 0; i < str.length(); i++) {
            hashTable[str.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < str.length(); i++) {
            if(hashTable[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }
        return '\0';
    }

    void unitTest1() {
        System.out.println(firstNoRepeatChar("abaccdeff"));
    }

    public static void main(String[] args) {
        FirstNoRepeatChar f = new FirstNoRepeatChar();
        f.unitTest1();
    }
}
