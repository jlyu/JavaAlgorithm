package MultiThread.TryThread;

public class MyCounter {

    private int value = 0;

    public synchronized int getValue() {
        value = value + 1;
        return value;
    }
}