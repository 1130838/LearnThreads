public class MainLT1 {

    public static void main(String[] args) {

        Counter counter = new Counter();
        counter.increment();
        System.out.println("im main thread. counter = " + counter.getValue());
    }
}
