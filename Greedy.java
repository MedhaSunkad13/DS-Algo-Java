import java.util.*;
import java.util.Arrays;

public class Greedy {

    static class Job {
        int deadline;
        int profit;
        int id; //0(A), 1(B), 2(C)

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

     //Activity Selection -> O(N)
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9}; //Unsorted

        //Sorting using 2D Arrays
        int activities[][] = new int[start.length][3];

        for(int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //Lambda Function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //End time basis sorted activities
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st Activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i = 1; i < end.length; i++) {
            if(activities[i][1] >= lastEnd){
                //Select Activity
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max Activities: " +maxAct);
        //Activities
        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A" +ans.get(i)+" ");
        }
        System.out.println();

        //Fractional Knapsack
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
        //0th col -> idx; 1st col = ratio

        for(int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double)wt[i];
        }
        //Ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        //Descending
        //Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]).reversed());

        int capacity = W;
        int finalVal = 0;
        //Reverse loop to sort in Descending order
        for(int i = ratio.length-1; i >= 0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= wt[idx]) { //Include full item
                finalVal += val[idx];
                capacity -= wt[idx];
            }
            else {
                //Include fractional Item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final Value = " +finalVal);

        //Minimum Sum Absolute Difference //O(nlogn)
        int A[] = {1, 3, 2};
        int B[] = {2, 1, 3};

        //Sorting
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        //Loop
        for(int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Minimum sum absolute difference between the pairs: "+minDiff);

        //Maximum Length Chain of pairs ->O(nlogn)
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        //Sorting
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1]; //Last selected pair end

        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max length of chain: " + chainLen);

        //Indians Coins
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        //Sorting in Descending order
        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins = 0;
        int amt = 690;
        ArrayList<Integer> answer = new ArrayList<>();

        //Selecting coins
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amt) {
                while (coins[i] <= amt) {
                    countOfCoins++;
                    answer.add(coins[i]);
                    amt -= coins[i];
                }
            }
        }
        System.out.println("Total minimum coins used: " +countOfCoins);

        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();

        //Job Sequencing
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>(); 

        for(int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        //Sort in desccending order -> Lambda function
        Collections.sort(jobs, (obj1, obj2) ->obj2.profit-obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }
        //Print Sequence
        System.out.println("Max jobs = " +seq.size());
        for(int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) +" ");
        }
        System.out.println();

        //Chocola Problem
        int n = 4, m = 6;
        
        Integer costVer[] = {2, 1, 3, 1, 4}; // m-1 cuts
        Integer costHor[] = {4, 1, 2}; // n-1 cuts

        // Sorting both arrays in descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // Pointers for costHor & costVer
        int hp = 1, vp = 1; // Initially 1 piece horizontally & vertically
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            // Choosing the cut that has the highest cost
            if (costVer[v] >= costHor[h]) {  // Vertical cut is more expensive
                cost += costVer[v] * hp;
                vp++;  // Increase vertical parts
                v++;
            } else {  // Horizontal cut is more expensive
                cost += costHor[h] * vp;
                hp++;  // Increase horizontal parts
                h++;
            }
        }

        // Process remaining horizontal cuts
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        // Process remaining vertical cuts
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println("Minimum cost of cuts = " + cost);
    }
}
