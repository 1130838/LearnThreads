public class MainLT5 {

    public static void main(String[] args) {

        final Worker worker = new Worker();
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker.process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker.process();
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



        long end = System.currentTimeMillis();

        System.out.println("Starting ..");
        System.out.println("time taken = " + (end - start) + " milliseconds");
        System.out.println("list1 size = " + worker.getList1().size() + " | listTwo size = " + worker.getList2().size());

    }
}
