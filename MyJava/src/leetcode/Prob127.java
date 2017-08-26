package leetcode;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by mdev on 7/23/17.
 * .
 */
public class Prob127 {

    Map<String, List<String>> graph = new HashMap<>();
    Set<String> visited = new HashSet<>();
    Integer minPath = null;

    public static void main(String[] args) {
        List<String> wordList = asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        Prob127 prob127 = new Prob127();
        System.out.println(prob127.ladderLength("qa", "sq", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> allWords = new ArrayList<>(wordList);
        allWords.add(beginWord);
        createGraph(allWords);
        dfs(beginWord, endWord, 1);
        return minPath==null?0:minPath;
    }

    public void dfs(String word, String expectedWord, int path) {
        visited.add(word);
        if (word.equals(expectedWord)) {
            if(minPath == null) minPath = path;
            else if (path < minPath)
                minPath = path;
        }
        List<String> neighbours = graph.get(word);
        for (String neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour, expectedWord, path+1);
                visited.remove(neighbour);
            }
        }
    }

    public void createGraph(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            if(graph.containsKey(words.get(i))) continue;
            graph.put(words.get(i), new ArrayList<>());
            for (int j = 0; j < words.size(); j++) {
                if (getDifference(words.get(i), words.get(j))) {
                    graph.get(words.get(i)).add(words.get(j));
                }
            }
        }
    }

    public boolean getDifference(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length() && diff <= 1; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }

        if (diff == 1)
            return true;
        return false;
    }

}
