import java.util.Objects;
import java.util.Vector;

public class MainLT6 {


    public static void main(String[] args) {

        Vector<Integer> vec = new Vector<Integer>();
        Object lock1 = new Object();

        final Producer producer = new Producer(vec, lock1);
        final Consumer consumer = new Consumer(vec, lock1);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer.fillVector();
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.consume();
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



        System.out.println("this is main thread and i've waited for all threads to finish with the join() method");

    }


}
