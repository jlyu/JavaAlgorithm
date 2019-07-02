package MultiThread.SingleThreadedExecution;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Testing Gate...");
//        Gate gate = new Gate();
//        new UserThread(gate, "Alice", "Alaska").start();
//        new UserThread(gate, "Bobby", "Brazil").start();
//        new UserThread(gate, "Chris", "Canada").start();

        BoundedResource resource = new BoundedResource(3);
        for (int i = 0; i < 10; i++) {
            new UserThread(resource).start();
        }
    }
}
