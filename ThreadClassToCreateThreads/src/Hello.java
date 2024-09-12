public class Hello {
    public static void main(String[] args) throws Exception {
        World world = new World();

        world.start();

        for(int i=0;i<100000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
