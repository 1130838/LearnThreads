import java.util.Vector;

/**
 * Created by bruno.devesa on 07-06-2015.
 */
public class Consumer {
    Object lock1;
    private Vector<Integer> vec;

    public Consumer(Vector vec, Object lock1) {
        this.vec = vec;
        this.lock1 = lock1;
    }

    // show the Vector
    public void consume() {

        synchronized (lock1) {

            try {
                lock1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print(Colors.ANSI_PURPLE);
            System.out.println("i'm the consumer thread and i'm consuming the Vector... ");
            for (int i = 0; i < vec.size(); i++) {
                System.out.println("vec[" + i + "] = " + vec.get(i));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Colors.ANSI_RESET);
        }
    }


}
