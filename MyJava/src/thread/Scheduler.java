package thread;


public class Scheduler {
	static final int COUNT = 3;
	static final int SLEEP = 37;
	public static void main(String args[]) {
		SimpleThread threads[] = new SimpleThread[COUNT];
		for(int i = 0; i < COUNT; ++i)
			threads[i] = new SimpleThread(i + 1);
		int index = 0;
		while(true){
			synchronized(threads[index]) {
				threads[index].notify();
			}
			try {
//				System.out.println("Thread sleeping for 37 millisecs");
				Thread.sleep(SLEEP);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			index = (++index) % COUNT;
		}
	}
}