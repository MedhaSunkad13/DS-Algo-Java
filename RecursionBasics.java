//import java.util.*;

public class RecursionBasics{

    public static void printnto1(int n) {
        if(n == 1) {
            System.out.print(n);
            return;
        }
         System.out.print(n + " ");
         printnto1(n-1);
    }

    public static void print1ton(int n) {
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }

        print1ton(n-1);
        System.out.print(n + " ");
    }

    public static int calcFactorial(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }
        //fnm1 = f(n-1)
        int fnm1 = calcFactorial(n-1);
        int fn = n * fnm1;
        return fn;
    }

    public static int sumOfFirstNNumbers(int n) {
        if(n == 1) {
            return 1;
        }

         int sum = n + sumOfFirstNNumbers(n-1);
         return sum;

    }

    public static int fibonacci(int n) {
        if((n == 0) || (n == 1)) {
           return n;
        }

        //int fnm1 = fibonacci(n-1);
        //int fnm2 = fibonacci(n-2)
        int fibN = fibonacci(n-1) + fibonacci(n-2);
        return fibN;
    }

    public static boolean is_Sorted(int arr[], int i) {
        if(i == arr.length-1) {
            return true;
        }

        if(arr[i] > arr[i+1]) {
            return false;
        }
        
        return is_Sorted(arr, i+1);
    }

    public static int firstOccurence(int arr[], int target, int i) {
        if(i == arr.length) {
            return -1;
        }

        if(arr[i] == target) {
            return i;
        }
        return firstOccurence(arr, target, i+1);
    }

     public static int lastOccurence(int arr[], int target, int i) {
        if(i == 0) {
            return -1;
        }

        if(arr[i] == target) {
            return i;
        }
        return firstOccurence(arr, target, i-1);
    }

    //Brute Force
    public static int power(int x, int n) { //O(n)
        if(n == 0) {
            return 1;
        }
        return x * power(x, n-1);
        // int xnm1 = power(x, n-1);
        // int xn = x * xnm1;
        // return xn;
    }

    public static int optimizedPower(int x, int n) { //O(logn)
        //BASE CASE
        if(n == 0) {
            return 1;
        }
        //if n is even
        int halfPow = optimizedPower(x, n/2);
        int halfPowSq = halfPow * halfPow;

        //if n is odd
        if(n % 2 != 0) {
           halfPowSq = x * halfPowSq;
        }

        return halfPowSq;
    }

    public static void printNumb(int n) {
        //base case
        if(n == 0) {
            return;
        }
        //printNumb(n-1);
        System.out.println(n);
        printNumb(n-1);
    }

    public static void main(String args[]) {
        // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 4};
        // int target = 5;
        //int n = 4;
        //printnto1(n);
        //print1ton(n);
        //System.out.print(calcFactorial(n));
        //System.out.println(sumOfFirstNNumbers(n));
        //System.out.print(fibonacci(n));
        //System.out.println(is_Sorted(arr, 0));
        //System.out.println("Index: " +firstOccurence(arr, target, 0));
        // System.out.println("Index: " +lastOccurence(arr, target, arr.length-1));
        // System.out.println(power(2, 5));
        // System.out.println(optimizedPower(2, 10));
        // System.out.println(printNumb(5));
        // System.out.println(printNSum(5));
        //System.out.print(printFactorial(5));
    }
}