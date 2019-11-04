package CodingRush._10_Math_Fibonacci;

public class Fibonacci {
    public static long fibonacci(int n) {
        if (n < 0) { return -1; }

        long[] result = {0, 1};
        if (n < 2) { return result[n]; }

        long fib1 = 0;
        long fib2 = 1;
        long fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;

        }
        return fib;
    }

    public static void main(String[] args) {

        System.out.println(Fibonacci.fibonacci(512));
    }
}
