package MultiThread.SingleThreadedExecution;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);

    public BoundedResource(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException {
        System.out.println("BEGIN: USED = " + ( permits - semaphore.availablePermits() ));
        Thread.sleep(random.nextInt(500));
        System.out.println("END: USED = "   + ( permits - semaphore.availablePermits() ));
    }


}
