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
    int itensProduced;
    int itensConsumed;

    Random random = new Random();

    public Producer(Vector<Integer> vec, Object lock1, Object lock2, int itensProduced, int itensConsumed) {
        this.vec = vec;
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.itensConsumed = itensConsumed;
        this.itensProduced = itensProduced;

    }

    public void fillVector() {

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10);

            synchronized (lock1) {
                vec.add(randomNumber);
                lock1.notify();
            }

            System.out.println("[" + Thread.currentThread().getName() + "] filling Vector with " + randomNumber);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            itensProduced++;

        }

        synchronized (lock1) {
           // lock1.notify();
        }


    }


    public Vector<Integer> getVec() {
        return vec;
    }
}
