package MessageQueue;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by mdev on 4/28/15.
 */
public class Consumer implements Observer {


    private String topicName;
    private String name;

    Consumer(String name, String topicName) {
        this.topicName = topicName;
        this.name = name;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Consumer :" + name + " got message : " + arg + " from topic : " + topicName);
    }

    public String getTopicName() {
        return topicName;
    }

}
