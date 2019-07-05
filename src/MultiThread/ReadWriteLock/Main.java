package MultiThread.ReadWriteLock;

public class Main {
    public static void main(String[] args) {
        Data data = new Data(10);
        for (int i=0; i < 3; i++) {
            new ReaderThread(data).start();
        }
        new WriterThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new WriterThread(data, "abcdefghijklmnopqrstuvwxyz").start();
    }
}
