public class ThreadPriority extends Thread {
    /**
     * wanna give your thread a custom name ?
     * have to create a constructor of your class and call the Thread class constructor
     * using super()
     */
    public ThreadPriority(String thread_name ) {
        super(thread_name);
    }
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            String s = "";
            for (int j = 0; j < 100000; j++) {
                s += "a";
            }
            System.out.println(getName() + " thread's state -> RUNNING" + " count -> " + (i+1) + " priority -> " + getPriority()); // RUNNABLE
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        ThreadPriority thread1 = new ThreadPriority("rookie-fire");
        ThreadPriority thread2 = new ThreadPriority("foolish-mad");
        ThreadPriority thread3 = new ThreadPriority("cyborg-prisoner");

        // giving manual priority
        thread1.setPriority(MIN_PRIORITY);
        thread2.setPriority(NORM_PRIORITY);
        thread3.setPriority(MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

        /**
         * Which completed the execution first -> the thread with highest priority
         * But the execution or which gets the CPU first this does not depends on the priority
         * it depends on the JVM how the implement
         * 
         * But this example would be perfectly shown on a single core machine
         * as my machine is multicore there is some possibility that some threads runs in parallel 
         */
    }
}
