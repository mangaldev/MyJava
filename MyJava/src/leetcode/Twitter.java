package leetcode;

import java.util.*;

/**
 * Created by mdev on 7/23/17.
 * .
 */
public class Twitter {

    Map<Integer, Set<Integer>> followerMap = new HashMap<>();
    Map<Integer, List<Tweet>> tweets = new HashMap<>();
    int tweetCounter = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        tweetCounter++;
        if (!followerMap.containsKey(userId)) {
            insertUser(userId);
        }
        tweets.get(userId).add(new Tweet(tweetId, tweetCounter));
    }

    private void insertUser(int userId) {
        followerMap.put(userId, new HashSet<>());
        tweets.put(userId, new LinkedList<>());
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!followerMap.containsKey(userId)) {
            insertUser(userId);
        }
        List<Integer> result = new LinkedList<>();
        int count = 0;
        PriorityQueue<PriorityQueueNode> queue = new PriorityQueue<>(new PairComparator());
        final Set<Integer> follwers = followerMap.get(userId);
        follwers.add(userId);
        for (Integer follower : follwers) {
            final int indexOfLastTweet = getIndexOfLastTweet(follower);
            if (indexOfLastTweet >= 0)
                queue.add(new PriorityQueueNode(follower, tweets.get(follower).get(indexOfLastTweet).tweetId, indexOfLastTweet, tweets.get(follower).get(indexOfLastTweet).tweetCounter));
        }
        do {
            if (queue.size() > 0) {
                final PriorityQueueNode latestTweet = queue.poll();
                result.add(latestTweet.tweetId);
                if (latestTweet.index > 0)
                    queue.add(new PriorityQueueNode(latestTweet.userId, tweets.get(latestTweet.userId).get(latestTweet.index - 1).tweetId, latestTweet.index - 1, tweets.get(latestTweet.userId).get(latestTweet.index - 1).tweetCounter));
            }
        } while (++count < 10);
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!followerMap.containsKey(followerId)) {
            insertUser(followerId);
        }
        if (!followerMap.containsKey(followeeId)) {
            insertUser(followeeId);
        }
        followerMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!followerMap.containsKey(followerId)) {
            insertUser(followerId);
        }
        if (!followerMap.containsKey(followeeId)) {
            insertUser(followeeId);
        }
        followerMap.get(followerId).remove(followeeId);
    }

    public int getIndexOfLastTweet(int userId) {
        return tweets.get(userId).size() - 1;
    }

    class Tweet {
        int tweetId;
        int tweetCounter;

        public Tweet(int tweetId, int tweetCounter) {
            this.tweetId = tweetId;
            this.tweetCounter = tweetCounter;
        }
    }

    class PriorityQueueNode {
        int tweetId;
        int index;
        int userId;
        int tweetCounter;

        public PriorityQueueNode(int userId, int tweetValue, int index, int tweetCounter) {
            this.tweetId = tweetValue;
            this.userId = userId;
            this.index = index;
            this.tweetCounter = tweetCounter;
        }
    }

    class PairComparator implements Comparator<PriorityQueueNode> {
        public int compare(PriorityQueueNode p1, PriorityQueueNode p2) {
            if (p1.tweetCounter > p2.tweetCounter)
                return -1;
            else
                return 1;
        }
    }


}
