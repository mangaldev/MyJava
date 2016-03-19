package MessageQueue;

/**
 * Created by mdev on 4/28/15.
 */
public class Producer {


    String topicName;
    JmsBroker jmsBroker;

    public Producer(String topicName, JmsBroker jmsBroker) {
        this.jmsBroker = jmsBroker;
        this.topicName = topicName;
    }

    public void sendMessage() {
        new Thread() {
            public void run() {
                int count = 0;
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    jmsBroker.sendMessage(topicName, "Message  " + count++ + " From : " + topicName);
                }
            }
        }.start();
    }
}
