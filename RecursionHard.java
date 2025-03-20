import java.util.*;

public class RecursionHard {

    
    public static void printPermutations(String str, String permutation) {   
        // Base Case
        if (str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i); 
            String newStr = str.substring(0, i) + str.substring(i + 1); 
            printPermutations(newStr, permutation + currChar); 
        }
    }

    public static int countPaths(int i, int j, int n, int m) {
        //base case
        if(i == n || j == m) {
            return 0;
        }

        if(i == n-1 && j == m-1) {
            return 1;
        }

        //move downwards
        int downPaths = countPaths(i+1, j, n, m);

        //move right
        int rigthPaths = countPaths(i, j+1, n, m);

        return downPaths + rigthPaths;
    }

    public static int placeTiles(int n, int m) {
        //Base Case:
        if( n == m ) {
            return 2;
        }

        if( n < m ) {
            return 1;
        }

        //Vertically
        int verticalPlacements = placeTiles(n-m, m);

        //Horizontally
        int horizontalPlacements = placeTiles(n-1, m);

        return verticalPlacements + horizontalPlacements;
    }

    public static int callGuests(int n) {
        //Base Case:
        if(n <= 1) {
            return 1;
        }

        //Single
        int ways1 = callGuests(n-1);

        //Pair
        int ways2 = (n-1) * callGuests(n-2);

        return ways1 + ways2;
    } 

    public static void printSubsets(ArrayList<Integer> subSet) {
        for(int i = 0; i < subSet.size(); i++) {
            System.out.print(subSet.get(i) + " ");
        }
        System.out.println();
    }

    public static void findSubsets(int n, ArrayList<Integer> subSet) {
        //Base Case:
        if(n == 0) {
            printSubsets(subSet);
            return;
        }

        //Gets added
        subSet.add(n);
        findSubsets(n-1, subSet);

        //Not gets added
        subSet.remove(subSet.size()-1);
        findSubsets(n-1, subSet);

    }


    public static void main(String[] args) {
        // String str = "abc";
        // printPermutations(str, ""); // Initial call
           //int n = 3, m = 2;
        // System.out.println(countPaths(0, 0, n, m));
        // System.out.println(placeTiles(n, m));
        //System.out.println(callGuests(n));
        // ArrayList<Integer> subSet = new ArrayList<>();
        // findSubsets(n, subSet);
    }
}
