package understanding;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsingThreeThreeSevenSenvenMake24 {
    public static void main(String[] args) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        List<Integer> input = Arrays.asList(3, 3, 7, 7);
        permute(input,0,result);
        for (List<Integer> integers : result) {
            expression("",integers.toArray(),0);
        }
    }

    static void permute(java.util.List<Integer> arr, int k,ArrayList<List<Integer>> result){

        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1,result);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            result.add(arr);
        }
    }

    private static void expression(String expression, Object[] arr, int index) {
        if (index == 4) {
            Integer result = 0;
            Object solve = solve(expression);
            if(solve instanceof Double){
                 result =  ((Double) solve).intValue();
            }
            else
            result = (Integer) solve;
            System.out.println(expression+" === "+result);
            if (result== 24) {
                System.out.println("Voilaaaaaaaaaaaaaaaaaaa !!!");
                System.out.println(expression);
            }
        }
        String[] opers = new String[]{"+", "-", "*", "/"};
        for (String oper : opers) {
            if (index == 0) {
                expression(arr[0] + oper + arr[1], arr, 2);
            } else if(index==2){
                expression( expression + oper + arr[2], arr, 3);
            }
            else if(index == 3){
                expression( expression + oper + arr[3], arr, 4);
            }
        }
    }

    private static Object solve(String s) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            return engine.eval(s);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
