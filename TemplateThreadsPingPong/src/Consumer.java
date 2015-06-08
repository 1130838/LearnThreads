//import sun.java2d.xr.MutableInteger;

import java.util.Vector;

/**
 * Created by brunodevesa on 08/06/15.
 */
public class Consumer {

    Vector<Integer> vec;
    Object lock1 = new Object();
    Object lock2 = new Object();
    MutableInteger itensProduced;
    MutableInteger itensConsumed;
    MutableInteger totalElements;
    MutableInteger numberOfThreads;

    public Consumer(Vector<Integer> vec, Object lock1, Object lock2, MutableInteger itensProduced, MutableInteger itensConsumed, MutableInteger totalElements, MutableInteger numberOfThreads) {
        this.vec = vec;
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.itensConsumed = itensConsumed;
        this.itensProduced = itensProduced;
        this.totalElements = totalElements;
        this.numberOfThreads = numberOfThreads;
    }

    public void showVector() {
        // int i = 0;

        synchronized (lock1) {
            do {
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (itensConsumed.getValue() != itensProduced.getValue()) {
/*
                    System.out.print(Colors.ANSI_BLUE);
                    System.out.println("vec [" + itensConsumed.getValue() + "] = " + vec.get(itensConsumed.getValue()));
                    System.out.print(Colors.ANSI_RESET);*/


                    System.out.print(Colors.ANSI_BLUE);
                    System.out.println("[" + Thread.currentThread().getName() + "] : " +
                            " vec[" + itensConsumed.getValue() + "] = " +
                            vec.get(itensConsumed.getValue()) +
                            " | vec size = " + vec.size() +
                            " | itens produced = " + itensProduced.getValue() + " | itens consumed = " + itensConsumed.getValue());

                    itensConsumed.increment();
                    System.out.print(Colors.ANSI_RESET);


                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } while (itensConsumed.getValue() < totalElements.getValue() * numberOfThreads.getValue());
        }


    }
}
