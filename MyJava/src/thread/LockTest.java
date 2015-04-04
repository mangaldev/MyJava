package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mdev on 3/28/15.
 */
public class LockTest {

    static ReentrantLock helloLock = new ReentrantLock();
    static ReentrantLock worldLock = new ReentrantLock();
    static ReentrantLock lock = new ReentrantLock();

    public static void print(String name){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();

        System.out.println("name = " + name);

        lock.unlock();
    }

    public static void main(String[] args) {
        LockTest test = new LockTest();
        new Thread(new HelloPrinter("Hello", worldLock)).start();
        new Thread(new WorldPrinter("World", helloLock)).start();
    }

    static class HelloPrinter implements Runnable {
        String name;
        ReentrantLock lock;

        public HelloPrinter(String name, ReentrantLock lock) {
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
//            while (true)
            print(name);
        }
    }

    static class WorldPrinter implements Runnable {
        String name;
        ReentrantLock lock;

        public WorldPrinter(String name, ReentrantLock lock) {
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
//            while (true)
            print(name);
        }
    }
}
