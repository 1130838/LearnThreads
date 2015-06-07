import java.util.Vector;

/**
 * Created by bruno.devesa on 07-06-2015.
 */

/*
Threads concurrently doing the method
 */
public class Producer {
    private Vector<Integer> vec;
    Object lock1;
    //  public int indexThread = 0;

    public Producer(Vector vec, Object lock1) {
        this.vec = vec;
        this.lock1 = lock1;
    }

    public void fillVector(int indexThread) {

        System.out.println("(producer thread " + Thread.currentThread().getName() + ") i'll begin filling the Vector... ");

        for (int i = 0; i < 5; i++) {

            synchronized (lock1) {
                if (indexThread == 0) {
                    // do bunch of thread work here :
                    vec.add(Integer.valueOf(i));
                    System.out.print(Colors.ANSI_BLUE);
                    System.out.println("thread " + Thread.currentThread().getName() + " filling the shared Vector with number " + Integer.valueOf(i) + " | indexThread = " + indexThread);
                    System.out.print(Colors.ANSI_RESET);
                }

                if (indexThread == 1) {
                    System.out.print(Colors.ANSI_GREEN);
                    vec.add(Integer.valueOf(i) * 2);
                    System.out.println("thread " + Thread.currentThread().getName() + " filling the shared Vector with number " + Integer.valueOf(i) * 2 + " | indexThread = " + indexThread);
                    System.out.print(Colors.ANSI_RESET);

                }
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("(producer thread " + Thread.currentThread().getName() + " ) : i finished ! ");
        System.out.print(Colors.ANSI_RESET);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (indexThread == 1) {
            synchronized (lock1) {
                System.out.println("producer thread " + Thread.currentThread().getName() + " released the mutex for consumer thread ");
                System.out.print(Colors.ANSI_RED);
                System.out.println("Consumer thread will start now..");
                System.out.print(Colors.ANSI_RESET);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.notify();

            }
        }

    }


}
