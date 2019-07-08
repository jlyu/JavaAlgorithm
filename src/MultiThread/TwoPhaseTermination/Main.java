package MultiThread.TwoPhaseTermination;

public class Main {
    public static void main(String[] args) {
        System.out.println("main start");

        try {
            CountupThread t = new CountupThread();
            t.start();

            Thread.sleep(5000);

            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            System.out.println("main: join" );
            System.out.println("1 thread t is alive = " + t.isAlive());
            t.join();
            System.out.println("2 thread t is alive = " + t.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");

    }
}
