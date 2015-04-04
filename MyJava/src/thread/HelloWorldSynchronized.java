package thread;

/**
 * Created by mdev on 3/28/15.
 */
public class HelloWorldSynchronized {
    static Object lock = new Object();

    public static void main(String[] args) {
        new HelloPrinter().start();
        new WorldPrinter().start();

    }

    static class HelloPrinter extends Thread {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    System.out.print("Hello");
                }
            }
        }
    }

    static class WorldPrinter extends Thread {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    System.out.println(" World");
                }
            }
        }
    }
}

