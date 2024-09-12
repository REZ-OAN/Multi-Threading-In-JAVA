public class ThreadLifeCycle extends Thread {

    @Override
    public void run() {
        System.out.println(getName()+ " threads state -> RUNNING");
        try {
            Thread.sleep(2000); // illustrate the waiting state
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws InterruptedException{

        ThreadLifeCycle t1 = new ThreadLifeCycle(); // New

        System.out.println(t1.getName()+ " threads state -> " + t1.getState());

        t1.start(); // Runnable

        System.out.println(t1.getName()+ " threads state -> " + t1.getState());


        System.out.println(Thread.currentThread().getName() + " threads state -> " + Thread.currentThread().getState()); // Runnable but it is the main thread which is in running state
        Thread.sleep(100); // waiting the main thread to give the cpu to t1
        System.out.println(t1.getName()+ " threads state -> " + t1.getState()); // waiting or blocked
        t1.join(); // waits for t1 thread to terminate
        System.out.println(t1.getName()+ " threads state -> " + t1.getState()); // terminated

    }
}
