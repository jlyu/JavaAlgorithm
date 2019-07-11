package MultiThread.TryThread;



public class Main {
    public static void main(String[] args) {

        MyCounter counter = new MyCounter();
//
//        MyThread t1 = new MyThread("Thread-1", counter);
//        MyThread t2 = new MyThread("Thread-2", counter);
//
//        t1.start();
//        t2.start();
//
//        new MyThread("Thread-3", counter).start();
//        new MyThread("Thread-4", counter).start();
//        new MyThread("Thread-5", counter).start();

        for (int i = 0; i < 10; i++) {

            new MyThread("Thread-" + i, counter).start();
        }
    }
}
