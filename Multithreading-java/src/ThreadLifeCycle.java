public class ThreadLifeCycle extends Thread {
    @Override
    public void run() {
        System.out.println("In Thread");

        for(int i=0; i<1000; i++) {
            System.out.println("RUNNING- Thread second ");
        }
    }
}
