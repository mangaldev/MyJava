package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloWorld {
	public static Object lock = new Object();

	public static void main(String... args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new Print("Hello", 3));
		executorService.execute(new Print("World", 4));
		executorService.shutdown();
	}

	static class Print implements Runnable {
		String str;
		int count;

		Print(String str, int count) {
			this.str = str;
			this.count = count;
		}

		@Override
		public void run() {
			while (count-- != 0) {
				synchronized (lock) {
					lock.notify();
					System.out.println(str);
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			synchronized (lock) {
				lock.notify();
			}
			System.out.println("Finsished");
		}

	}
}
