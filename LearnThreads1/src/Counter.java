/**
 * Created by brunodevesa on 07/06/15.
 */

/* run this several times. you will see diferentes values for 'value'. not always 20000
this shows the threads are not syncronized. while one thread is making the increment ( 3 operation)
the other one is also using the same variable 'value' so the result will be upredictable
 */

public class Counter {

    private int value;

    public void increment(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000 ; i++) {
                    value++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000 ; i++) {
                    value++;
                }
            }
        });

        t1.start();
        t2.start();
    }

    public int getValue() {
        return value;
    }
}
