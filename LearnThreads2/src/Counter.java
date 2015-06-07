/**
 * Created by brunodevesa on 07/06/15.
 */
/* with the join() it will help but it will NOT solve the problem

 */

public class Counter {

    private int value;

    public void doWork() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
                   value++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
                    value++;
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
