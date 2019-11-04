package CodingRush._16_Math_Power;


public class Power {
    public double power(double base, int exp) {
        if (exp < 0) { return 0.0; }
        if (exp == 0) { return 1.0; }
        if (exp == 1) { return base; }

        double result = power(base, (exp >> 1));
        result *= result;

        if ((exp & 0x1) == 1) {
            result *= base;
        }

        return result;
    }

    void unitTest1() {
        System.out.println(power(2, -1));
        System.out.println(power(5, 0));
        System.out.println(power(5, 6));
    }

    public static void main(String[] args) {
        Power p = new Power();
        p.unitTest1();
    }
}
