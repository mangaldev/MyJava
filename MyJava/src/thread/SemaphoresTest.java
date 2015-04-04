package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by mdev on 3/27/15.
 */
public class SemaphoresTest {

    public static String staticLock = new String("I am a static lock");
    public String lock = new String("I am a normal lock");
    private int index;
    CountDownLatch latch = new CountDownLatch(10);
    CyclicBarrier barrier = new CyclicBarrier(100);


    public SemaphoresTest(int index) {
        barrier.reset();
        this.index = index;
    }

    public synchronized void methodLevelSemaphore() throws InterruptedException {
        System.out.println("SemaphoresTest.methodLevelSemaphore");
        Thread.sleep(2000);
    }

    public static synchronized void staticmethodLevelSemaphore() throws InterruptedException {
        System.out.println("SemaphoresTest.staticmethodLevelSemaphore");
        Thread.sleep(2000);
    }

    // Use of this or lock is the same thing
    public void blockLevelSemaphore() throws InterruptedException {
        synchronized (this) {
            System.out.println("SemaphoresTest.blockLevelSemaphore");
            Thread.sleep(2000);
        }
    }

    //use of staticLock and SemaphoresTest.class is the same thing
    public void blockLevelStaticSemaphore() throws InterruptedException {
        System.out.println("SemaphoresTest.blockLevelStaticSemaphore : Waiting "+ this.index);
        latch.await();
        synchronized (SemaphoresTest.class) {
            Thread.sleep(2000);
        }
        System.out.println("SemaphoresTest.blockLevelStaticSemaphore : Lock Released by "+ this.index);
    }

    public void fire(){
        System.out.println("Called FIRE for : "+index);
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoresTest test1 = new SemaphoresTest(1);
        SemaphoresTest test2 = new SemaphoresTest(2);

        new TestThread(test1).start();
        new TestThread(test2).start();
        System.out.println("sleeping for 10 sec");
        Thread.sleep(10000);
        test1.fire();
        test2.fire();

    }

    static class TestThread extends Thread {

        private SemaphoresTest sema;

        public TestThread(SemaphoresTest sema) {
            this.sema = sema;
        }

        @Override
        public void run() {
            try {
                sema.methodLevelSemaphore();
                sema.blockLevelSemaphore();
                sema.blockLevelStaticSemaphore();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
