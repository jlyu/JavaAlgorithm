package MultiThread.SingleThreadedExecution;

import java.util.Random;

public class UserThread extends Thread {
//    private final Gate gate;
//    private final String myname;
//    private final String myaddress;

    private final static Random random = new Random(26535);
    private final BoundedResource resource;

//    public UserThread(Gate gate, String myname, String myaddress) {
//        this.gate = gate;
//        this.myname = myname;
//        this.myaddress = myaddress;
//    }

    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

//    public void run() {
//        System.out.println(myname + "Begin");
//        while (true) {
//            gate.pass(myname, myaddress);
//        }
//    }

    public void run() {
        try {
            while (true) {
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {

        }
    }
}
