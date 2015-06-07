import java.util.Vector;

/**
 * Created by bruno.devesa on 07-06-2015.
 */
public class Producer {
    private Vector<Integer> vec;
    Object lock1;

    public Producer(Vector vec, Object lock1) {
        this.vec = vec;
        this.lock1 = lock1;
    }

    public void fillVector() {
        System.out.print(Colors.ANSI_BLUE);
        System.out.println("(producer thread) : i'm filling the Vector... ");

        synchronized (lock1) {

            for (int i = 0; i < 10; i++) {
                vec.add(Integer.valueOf(i));
                System.out.println("filling pos " + vec.get(i));

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("(producer thread) : i finished ! ");
            System.out.print(Colors.ANSI_RESET);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock1.notify();
        }
    }

    public Vector<Integer> getVec() {
        return vec;
    }
}
