package MultiThread.TwoPhaseTermination;

import java.util.concurrent.*;

public class CyclicBarrierMain {
    private static final int THREADS = 3;

    public static void main(String[] args) {
        System.out.println("StaRT");

        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier Action!");
            }
        };

        CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, barrierAction);
        CountDownLatch doneLatch = new CountDownLatch(THREADS);

        try {
            for (int t = 0; t < THREADS; t++) {
                service.execute(new CyclicBarrierTask(phaseBarrier, doneLatch, t));
            }

            System.out.println("Await~~");
            doneLatch.await();

        } catch (InterruptedException e) {
        } finally {
            service.shutdown();
            System.out.println("EnD");
        }


    }
}
