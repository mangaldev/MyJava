package thread;

/**
 * Created by mdev on 3/28/15.
 */
public class HelloWorldAlternate {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        new HelloPrinter().start();
        new WorldPrinter().start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock2) {
            lock2.notifyAll();
        }
    }

    static class HelloPrinter extends Thread {
        public void run() {
            while (true) {
                synchronized (lock2) {
                    try {
                        lock2.wait();
//                        System.out.println("Hello is Waiting ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Hello");
                }
                synchronized (lock1) {
                    lock1.notify();
                }
            }
        }
    }

    static class WorldPrinter extends Thread {
        public void run() {
            while (true) {
                synchronized (lock1) {
                    try {
                        lock1.wait();
//                        System.out.println("World is Waiting ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("World");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    lock2.notify();
                }
            }

        }
    }
}

