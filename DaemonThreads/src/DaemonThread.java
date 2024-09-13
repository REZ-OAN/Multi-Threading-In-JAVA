public class DaemonThread extends Thread {

    @Override
    public void run() {
        for(int i=0;i<5;i++){

            System.out.println(getName() + " thread's state -> RUNNING");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        DaemonThread t1 = new DaemonThread();
        DaemonThread t2 = new DaemonThread();

        t1.setDaemon(true);
        t1.start(); // daemon thread it will running in the background (not controlled by the JVM)
        t2.start(); // user thread
        System.out.println(Thread.currentThread().getName() + " is done");

    }
}
