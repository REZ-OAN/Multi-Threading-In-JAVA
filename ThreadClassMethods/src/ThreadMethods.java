public class ThreadMethods extends Thread {
    /**
     * wanna give your thread a custom name ?
     * have to create a constructor of your class and call the Thread class constructor
     * using super()
     */
    public ThreadMethods(String thread_name ) {
        super(thread_name);
    }
    @Override
    public void run() {
        System.out.println(getName() + " thread's state -> RUNNING");
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " thread's state -> " + getState() + " priority -> " + getPriority()); // RUNNABLE
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " says " + i);
        }
    }

    /**
     * run() method is overridden
     * it is the method where we will write the logic which will be executed by the thread
     * .sleep() method is responsible for keeping the thread in the waiting queue for a specific time
     */
    public static void main(String[] args) throws Exception {
        ThreadMethods thread = new ThreadMethods("rookie-fire");

        // giving manual priority
        thread.setPriority(6);
        thread.start();
        /**
         * .start() is a method of Thread Class which supposed to change the thread state
         * from NEW to RUNNABLE
         */

         for (int i = 0; i < 5; i++) {
            Thread.sleep(800); 
            System.out.println(Thread.currentThread().getName()+ " thread is checking " + thread.getName() + " thread's state -> " + thread.getState() + " priority -> " + thread.getPriority()); // TIMED_WAITING
            /**
             * .currentThread() gives the currently executing threads object
             * .getName() gives the name of the thread
             * .getState() gives the thread state
             * .getPriority() gives the treads priority we can set it manually
             */
        }
        
        thread.join();
        /**
         * .join() it gives the execution for the caller after complete execution of the callee thread
         */
        System.out.println(thread.getName() + " thread's state -> " + thread.getState());
    }
}
