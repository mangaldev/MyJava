package urban;

import java.util.*;

/**
 * Created by mdev on 5/7/15.
 */


public class BallBoxFit {
    static int[] balls = {10,6,2,3,4,11,100,5};
    static int[] boxes = {100,11,2,3,4,10,6,5};

    static Map<Integer,Integer> resultMap = new LinkedHashMap<>();
    static Map<Integer,Integer> boxMap = new TreeMap<>();

    public static void main(String[] args) {
        fitBalls();
        System.out.println(resultMap.toString());
    }

    public static void fitBalls(){
        BallBoxFit problem = new BallBoxFit();
        for (int i = 0; i < balls.length; i++) {
            int boxToSearch = balls[i];
            int index = problem.searchInBoxes(boxToSearch);
            boxMap.put(boxes[index],index);
            resultMap.put(balls[i],index);
        }
    }

    public int searchInBoxes(int pivot) {
         int first  = 0;
        int last = boxes.length - 1;
        while(first < last){
            while(boxes[first] < pivot)
                first++;
            while(boxes[last] > pivot)
                last--;
            if(first<last){
                int temp = boxes[first];
                boxes[first] = boxes[last];
                boxes[last] = temp;
            }
        }
        return last;
    }

    public  int searchInBoxess(int pivot) {
        Set<Integer> input = boxMap.keySet();
        int[] sortedBoxes = new int[input.size()];
        int count = 0;
        for(Integer box : input){
            sortedBoxes[count] = box;
            count++;
        }
        int key = 0;
        int first = 0;
        int last = boxes.length - 1;
        for (int i = 0; i < sortedBoxes.length; i++) {
            if(pivot < sortedBoxes[i]){
                key = i;
                break;
            }
        }
        first  = (key == 0)?boxMap.get(0): boxMap.get(key-1);
        last = (key==boxMap.size()-1)?boxMap.get(boxMap.size()-1): boxMap.get(key+1);

        while(first < last){
            while(boxes[first] < pivot)
                first++;
            while(boxes[last] > pivot)
                last--;
            if(first<last){
                int temp = boxes[first];
                boxes[first] = boxes[last];
                boxes[last] = temp;
            }
        }
        return last;
    }


}
