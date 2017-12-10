package java8;

import java.util.Timer;
import java.util.TimerTask;

public class test {
    public static void main(String[] args) throws InterruptedException {
        final long thresholdTime = 11 * 1000;//in seconds
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Game Over. Couldn't cancel the time bomb.... Booommm.");
                System.exit(0);
            }
        }, thresholdTime);

        // Normall processing of program...
        //TimeUnit.SECONDS.sleep(10);
        // When you think you are good with your inputs.. call this
        timer.cancel();

    }
}
