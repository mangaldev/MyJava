package MessageQueue;

/**
 * Created by mdev on 4/28/15.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        JmsBroker jmsBroker = new JmsBroker();

        String topicName = "Topic1";

        Producer p1  = new Producer(topicName, jmsBroker);

        Consumer c1 = new Consumer("Consumer1",topicName);

        Consumer c2 = new Consumer("Consumer2",topicName);

        jmsBroker.addObserver(c1);

        jmsBroker.addObserver(c2);

        p1.sendMessage();
    }
}
