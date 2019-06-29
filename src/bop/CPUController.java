package bop;
import java.util.*;

public class CPUController {

    
    public void run() throws InterruptedException {
        while (true) {
            //for (int i = 0; i < 2000000000; i++) { ; }
            //for (int i = 0; i < 400000000; i++) { ; }
            //Thread.sleep(10);
            //System.out.println("loop");
        }
    }


    public static void main(String[] args) {
        
        try {
            CPUController cpu = new CPUController();
            System.out.println("start run");
            cpu.run();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

    }
}




