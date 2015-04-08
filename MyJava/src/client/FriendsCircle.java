package client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mdev on 4/8/15.
 */
public class FriendsCircle {

    public static void main(String[] args) {
        String[] friends = new String[]{"YYNN", "YYYN", "NYYN", "NNNY"};
        String[] friends1 = new String[]{"YNNNN", "NYNNN", "NNYNN", "NNNYN","NNNNY"};
        int result = friendCircles(friends1);
        System.out.println("result = " + result);
    }

    static int friendCircles(String[] friends) {
        List<Set> list = new ArrayList<>();

        for (int friend = 0; friend < friends.length; friend++) {
            String contacts = friends[friend];
            for (int contact = 0; contact < contacts.length(); contact++) {
                Set<Integer> s1 = null, s2 = null;
                if (contacts.charAt(contact) == 'Y') {
                    for (Set s : list) {
                        if (s.contains(friend))
                            s1 = s;
                        if (s.contains(contact))
                            s2 = s;
                    }
                    if (s1 == null && s2 == null) {
                        Set<Integer> newSet = new HashSet<>();
                        newSet.add(contact);
                        newSet.add(friend);
                        list.add(newSet);
                    } else if (s1 == null && s2 != null) {
                        s2.add(friend);
                    } else if (s2 == null && s1 != null) {
                        s1.add(contact);
                    } else {//both not null
                        if(s1 != s2) {
                            for (Integer s : s2) {
                                s1.add(s);
                            }
                            list.remove(s2);
                        }

                    }
                }
            }

        }
        System.out.println(list);
        return list.size();
    }
}
