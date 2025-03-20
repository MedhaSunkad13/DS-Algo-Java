//import java.util.*;

public class RainwaterAndStocks {

    public static int trappedRainwater(int height[]) {
        //Calculate left max array
        int n = height.length;
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //Calculate right max array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

    //Calculate trapped rainwater
        int trappedWater = 0;
        for(int i = 0; i < n; i++) {
            //WL = min(leftMax bound, rightMax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterLevel - height[i]);
        }
        return trappedWater;
    }

    public static int buyAndSellStocks(int prices[]) {
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            if(buyingPrice < prices[i]) {
                //Profit = Selling Price(prices[i]) - Buying Price
                int profit = prices[i] - buyingPrice; //today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyingPrice = prices[i];
            }
        }
        return maxProfit;
    }


    public static void main(String args[]) {
        
        // int height[] = {4, 2, 0, 6, 3, 2, 5};
        // System.out.println(trappedRainwater(height));

        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit = " +buyAndSellStocks(prices));
    }
}