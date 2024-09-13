public class ThreadYield extends Thread{

    public ThreadYield(String thread_name) {
        super(thread_name);
    }
    @Override 

    public void run() {
        for (int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName() + " thread's state -> RUNNING");

            Thread.yield();
            /**
             * by using .yield() method tells or suggest (like gives hint) the scheduler to give a chance to other threads for getting the cpu
             * and this is done by the scheduler 
             * again this example can be perfectly shown on single core machines
             * in multicore machines there has chance that they run in parallel
             */
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadYield t1 = new ThreadYield("t1");
        ThreadYield t2 = new ThreadYield("t2");

        t1.start();
        t2.start();

    }
}
