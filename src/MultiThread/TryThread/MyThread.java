package MultiThread.TryThread;
import java.lang.Thread;


public class MyThread extends Thread {
    private final MyCounter counter;

    public MyThread(String name, MyCounter counter) {
        super(name);
        this.counter = counter;
    }

    public void run() {

        while (true) {
            final int c = counter.getValue();

            //System.out.println(Thread.currentThread().getName() + ", Value = " + c);
            if (c % 10000 == 0) {
                System.out.println("███████████████████████████████████████████████████████████████" + (c / 10000) + "w ");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



