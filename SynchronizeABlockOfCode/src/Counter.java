public class Counter {
    private int count = 0;


    // this here the instruction count++ is accessed simultaneously by the threads
    // we can synchronize this instruction
    // this will solve the issue of reading the same value problem
    // and this block in called critical section of a program
    public void  increment(){
        /**
         * why this ?
         * what does it mean?
         * 
         * meaning =>
         * When an instance in which the increment() method is getting called, if multiple threads wants to
         * access the same instance then at a time only one thread can access the instance
         * 
         */
        synchronized(this){
            count++;
        }
        
    }

    public int getCount() {
        return count;
    }

}
