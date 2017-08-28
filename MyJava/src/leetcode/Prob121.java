package leetcode;

public class Prob121 {
    public int maxProfit(int[] prices) {
        int[] minprices = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for(int i =0 ;i < prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }
            minprices[i] = min;
        }

        int maxProfit = 0;
        for(int i =0 ;i < prices.length;i++){
            if(prices[i] - minprices[i] > maxProfit){
                maxProfit = prices[i] - minprices[i] ;
            }
        }
        return maxProfit;
    }
}
