package MultiThread.ThreadSpecificStorage;

public class Main {
    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
    }
}
