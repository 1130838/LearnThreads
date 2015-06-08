//import sun.java2d.xr.MutableInteger;
import java.util.Vector;

public class MainLT8 {

    public static void main(String[] args) {

        Vector<Integer> vec = new Vector<Integer>();
        Object lock1 = new Object();
        Object lock2 = new Object();
        MutableInteger itensProduced = new MutableInteger(0);
        MutableInteger itensConsumed = new MutableInteger(0);
        MutableInteger totalElements = new MutableInteger(10);

        MutableInteger numberOfThreads = new MutableInteger(2);


        final Producer producer = new Producer(vec, lock1, lock2, itensProduced, itensConsumed, totalElements);
        final Consumer consumer = new Consumer(vec, lock1, lock2, itensProduced, itensConsumed, totalElements, numberOfThreads);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.fillVector();

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.fillVector();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.showVector();
            }
        });

        t1.setName("Producer_ThreadOne");
        t2.setName("Producer_ThreadTwo");
        t3.setName("Consumer_ThreadOne");

        t1.start();
        t2.start();
        t3.start();

        //main thread waits for her created threads
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


}
