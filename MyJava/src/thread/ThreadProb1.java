package thread;

/**
 * Created by mdev on 3/29/15.
 */
public class ThreadProb1 {

    public static Object lock = new Object();

    public static void main(String[] args) {
        new Printer(1).start();
        new Printer(2).start();
        synchronized (lock) {
            lock.notify();
        }
        synchronized (lock) {
            lock.notify();
        }
    }


    static class Printer extends  Thread{
        int count;

        public Printer(int count) {
            this.count = count;
        }

        public void run() {
            print(count);
        }
    }

    static void  print(int count){
        synchronized (lock) {
            try {
                System.out.println("Waiting :"+count);
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("count = " + count);
        }
    }
}
