package thread;

public class SimpleThread extends Thread {
	private int value;
	public SimpleThread(int num) {
		this.value = num;
		start();
	}
	public void run() {
		while(true) {
			synchronized(this) {
				try {
					wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.print(value + " ");
			}
		}
	}
}