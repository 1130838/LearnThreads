import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bruno.devesa on 07-06-2015.
 */

/*
Threads  synchronized. every run will get SAME result
 */

public class Worker {

    private Random randomNumber = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();


    public void stageOne() {
        synchronized (lock1) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(randomNumber.nextInt(100));

        }
    }

    public void stageTwo() {
        synchronized (lock2) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(randomNumber.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public List<Integer> getList1() {
        return list1;
    }

    public List<Integer> getList2() {
        return list2;
    }


}
