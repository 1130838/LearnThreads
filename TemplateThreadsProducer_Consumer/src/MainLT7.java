import java.util.Vector;

public class MainLT7 {


    public static void main(String[] args) {

        Vector<Integer> vec = new Vector<Integer>();
        Object lock1 = new Object(); // mutex
        final int[] orderOfThread = {0, 1};
        final Producer producer = new Producer(vec, lock1);
        final Consumer consumer = new Consumer(vec, lock1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.fillVector(orderOfThread[0]);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.fillVector(orderOfThread[1]);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.consume();
            }
        });

        t1.setName("FirstThread");
        t2.setName("SecondThread");
        t3.setName("ConsumerThread");

        t1.start();
        t2.start();
        t3.start();

        //main thread waits for all threads she create finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("this is main thread and i've waited for all threads to finish with the join() method");


    }



}
