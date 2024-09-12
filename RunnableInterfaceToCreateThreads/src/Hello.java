public class Hello {
    public static void main(String[] args) throws Exception {

        World world = new World();

        Thread t1 = new Thread(world);

        t1.start();
        for(int i=0;i<100000;i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
