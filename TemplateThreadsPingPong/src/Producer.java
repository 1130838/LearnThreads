//import sun.java2d.xr.MutableInteger;

import java.util.Random;
import java.util.Vector;

/**
 * Created by brunodevesa on 08/06/15.
 */

/* this class will have 1 thread1:
threadOne : fill a vector with random numbers
 */

public class Producer {


    Vector<Integer> vec;
    Object lock1 = new Object();
    Object lock2 = new Object();
    MutableInteger itensProduced;
    MutableInteger itensConsumed;
    MutableInteger totalElements;

    Random random = new Random();

    public Producer(Vector<Integer> vec, Object lock1, Object lock2, MutableInteger itensProduced, MutableInteger itensConsumed, MutableInteger totalElements) {
        this.vec = vec;
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.itensConsumed = itensConsumed;
        this.itensProduced = itensProduced;
        this.totalElements = totalElements;
    }

    public void fillVector() {

        for (int i = 0; i < totalElements.getValue(); i++) {
            int randomNumber = random.nextInt(10);

            synchronized (lock1) {
                vec.add(randomNumber);
                itensProduced.setValue(itensProduced.getValue() + 1);
                lock1.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(Colors.ANSI_PURPLE);
            System.out.println("[" + Thread.currentThread().getName() + "] filling Vector with " + randomNumber);
            System.out.print(Colors.ANSI_RESET);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}




