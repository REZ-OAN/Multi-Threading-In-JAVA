public class Test {
    public static void main(String[] args) throws Exception {
        
        // initialize a new counter
        Counter counter = new Counter();

        // creating the threads
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);

        // starting the two threads which will execute simultaneously
        thread1.start();
        thread2.start();

        
        // waiting threads execution to be finished
        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            throw new Exception(e);
        }

        // after execution completion printing the count
        System.out.println(counter.getCount());
    }
}
