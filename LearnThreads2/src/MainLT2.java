public class MainLT2 {

    public static void main(String[] args) {

        Counter counter = new Counter();
        counter.doWork();
        System.out.println("im main thread. counter = " + counter.getValue());
    }
}
