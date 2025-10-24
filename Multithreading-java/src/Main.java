public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()); //main
        System.out.println(Thread.currentThread().getState()); // RUNNABLE

        Thread t1 = new ThreadLifeCycle();
        System.out.println( t1.getState());  // NEW

        t1.start();
        System.out.println( t1.getState());   // RUNNABLE

        Thread.sleep(200);
        System.out.println(Thread.currentThread().getState());
        t1.join();

        for(int i=0; i<4; i++) {
            System.out.println("Main Thread");
        }
        System.out.println( t1.getState());



    }
}