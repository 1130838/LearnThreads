/**
 * Created by brunodevesa on 07/06/15.
 */
/* with the keyword synchronized in the method declaration, problem will get SOLVED !
only one thread at the time will have the 'value' variable at a time
 */

public class Counter {

    private int value;

    public synchronized void increment(){
        value++;
    }

    public synchronized void decrement(){
        value--;
    }

    public void doWork() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
                   increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
                    decrement();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getValue() {
        return value;
    }
}
