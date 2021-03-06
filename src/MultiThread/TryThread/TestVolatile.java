package jav;

public class TestVolatile {
    public volatile int inc = 0;

    public void increase() { inc++; }

    public static void main(String[] args) {
        final TestVolatile test = new TestVolatile();

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) { test.increase(); }
                }
            }.start();
        }

        //保证前面的线程都执行完
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(test.inc);
    }
}


