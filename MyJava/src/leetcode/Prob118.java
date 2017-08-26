package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Prob118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> prevRow = null;
        List<Integer> currentRow = null;
        for (int i = 0; i < numRows; i++) {
            currentRow = new ArrayList<>();
            if (prevRow == null) {
                currentRow.add(1);
            } else {
                currentRow.add(prevRow.get(0));
                for (int j = 0; j < prevRow.size() - 1; j++) {
                    currentRow.add(prevRow.get(j) + prevRow.get(j + 1));
                }
                currentRow.add(prevRow.get(prevRow.size() - 1));
            }
            prevRow = currentRow;
            result.add(currentRow);
        }
        return result;
    }
}
