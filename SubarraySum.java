//import java.util.*;

public class SubarraySum {

    public static void printSubArrays(int nums[]) {
        int sum = 0;
        int minVal = Integer.MAX_VALUE; // +infinity
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            for (int j = i; j < nums.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print("[" + nums[k] + "]"); // Subarray
                    sum = sum + nums[k];
                }
                System.out.println(" Sum = " + sum);

                // Minimum
                if (minVal > sum) {
                    minVal = sum;
                }

                // Maximum
                if (maxVal < sum) {
                    maxVal = sum;
                }

                sum = 0;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Minimum Value is " + minVal);
        System.out.println("Maximum Value is " + maxVal);
        System.out.println("Total Subarrays = " + (nums.length * (nums.length + 1)) / 2);
    }

    public static void maxSubarraySum(int nums[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[nums.length];

        prefix[0] = nums[0];

        //Calculate prefix sum array
        for(int i = 1; i < nums.length; i++) {
           prefix[i] = prefix[i-1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            for (int j = i; j < nums.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1]; 
                // for (int k = start; k <= end; k++) { 
                //     currSum += nums[k];
                // }
                // System.out.println("Current Sum = " + currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max Sum = " + maxSum);
    }

    public static void kadanesSubarraySum(int nums[]) {
    int currSum = nums[0]; 
    int maxSum = nums[0];  

    for (int i = 1; i < nums.length; i++) {
        if (currSum < 0) {
            currSum = nums[i]; 
        } else {
            currSum += nums[i];
        }

        maxSum = Math.max(maxSum, currSum); 
    }
    System.out.println("Max sum = " + maxSum);
}

public static void kadanesAlgorithm(int nums[]) {
    //not applicable if array contains all -ve numbers
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length; i++) {
        currSum += nums[i];

        if(currSum < 0) {
        currSum = 0;
    }
    maxSum = Math.max(currSum, maxSum);
    }

    System.out.println("Max Sum = " +maxSum);
}


    public static void main(String args[]) {
        //int nums[] = {2, 4, 6, 8, 10};
        //printSubArrays(nums);
        //int nums[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        //kadanesSubarraySum(nums);
        //maxSubarraySum(nums);
        //kadanesAlgorithm(nums);
    }
} 
