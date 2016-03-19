package MessageQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mdev on 4/28/15.
 */

public class Topic extends Observable {

    private String name;
    private Deque<String> queue = new ArrayDeque<>();

    Topic(String name) {
        this.name = name;
    }

    public void addMessage(String str) {
        queue.add(str);
        this.setChanged();
        this.notifyObservers(str);
    }
}
