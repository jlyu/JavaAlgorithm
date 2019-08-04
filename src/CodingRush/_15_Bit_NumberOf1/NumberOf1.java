package CodingRush._15_Bit_NumberOf1;

public class NumberOf1 {
    public int numberOf1(int n) {

        int count = 0;
        int flag = 1;
        while ((flag == 0) ? false : true) {

            if ((n & flag) == 0 ? false : true)  { count++; }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1 n = new NumberOf1();
        System.out.println( n.numberOf1(9) );
    }
}
