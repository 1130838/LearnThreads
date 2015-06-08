import java.util.Vector;

/**
 * Created by brunodevesa on 08/06/15.
 */
public class Consumer {

    Vector<Integer> vec;
    Object lock1 = new Object();
    Object lock2 = new Object();
    int itensProduced;
    int itensConsumed;

    public Consumer(Vector<Integer> vec, Object lock1, Object lock2, int itensProduced, int itensConsumed) {
        this.vec = vec;
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.itensConsumed = itensConsumed;
        this.itensProduced = itensProduced;
    }


    public void showVector() {
        int i = 0;


        do {

            synchronized (lock1) {
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(Colors.ANSI_BLUE);
                System.out.println("vec [" + i + "] = " + vec.get(i));
                System.out.print(Colors.ANSI_RESET);
            }
              System.out.println("thread consumer. vec size = " + vec.size() + " i = " + i);
            itensConsumed++;
            i++;
        } while (i < vec.size());

        /*    synchronized (lock2) {

                lock2.notify();
            }*/
        // Thread.sleep(200);


    }
}
