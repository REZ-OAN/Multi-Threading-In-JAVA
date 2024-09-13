public class Counter {
    private int count = 0;


    // this function is accessed simultaneously by the threads so we Synchronize this function
    // this will solve the issue of reading the same value problem
    // it's make sure only one thread at a time can execute or process this function
    public synchronized void  increment(){
        count++;
    }

    public int getCount() {
        return count;
    }

}
