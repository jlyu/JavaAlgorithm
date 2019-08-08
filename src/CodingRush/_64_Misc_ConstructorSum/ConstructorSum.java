package CodingRush._64_Misc_ConstructorSum;


public class ConstructorSum {
    private static int n = 0;
    private static int sum = 0;

    ConstructorSum() {
        ConstructorSum.n++;
        ConstructorSum.sum += ConstructorSum.n;
    }

    public static int getSum() {
        return sum;
    }

    public int solution(int n) {
        ConstructorSum s = new ConstructorSum();
        return ConstructorSum.getSum();
    }

    public static void main(String[] args) {
        final int N = 10;
        ConstructorSum s = new ConstructorSum();
        System.out.println(s.solution(N));
    }
}
