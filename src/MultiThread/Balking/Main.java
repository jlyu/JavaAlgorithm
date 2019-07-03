package MultiThread.Balking;

import java.util.concurrent.TimeoutException;

public class Main {
    public static void testSaverChanger() {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }

    public static void testHost(){
        Host host = new Host(1000);
        try {
            System.out.println("execute Begin");
            host.execute();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Main.testHost();
    }
}
