package MultiThread.GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final long TIMEOUT = 30000L;
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        long start = System.currentTimeMillis();


        while (queue.peek() == null) {
            long now = System.currentTimeMillis();
            long rest = TIMEOUT - (now - start);

            if (rest <= 0) {
                throw new LivenessException("Liveness exception: " + Thread.currentThread().getName());
            }
            try {
                wait(rest);
            } catch (InterruptedException ex) {
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }




}
