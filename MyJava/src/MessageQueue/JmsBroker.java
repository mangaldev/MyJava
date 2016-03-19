package MessageQueue;

import java.util.*;

/**
 * Created by mdev on 4/28/15.
 */
public class JmsBroker {

    private final Map<String, Topic> topicMap = new HashMap<>();

    public void sendMessage(String topicName,String msg) {
        if(!topicMap.containsKey(topicName)) {
            Topic topic = new Topic(topicName);
            topicMap.put(topicName, topic);
        }
        topicMap.get(topicName).addMessage(msg);
    }

    public void addObserver(Consumer o){
        if(!topicMap.containsKey(o.getTopicName())) {
            topicMap.put(o.getTopicName(), new Topic(o.getTopicName()));
        }
        topicMap.get(o.getTopicName()).addObserver(o);
    }


}
