//import java.util.*;

public class Arrays {

    // public static void update(int marks[]) {
    //     for(int i = 0; i < marks.length; i++) {
    //         marks[i] = marks[i] + 1;
    //     }
    // }

    //public static int linearSearch(String words[], String key) {
        // for(int i=0; i<nums.length; i++) {
        //     if(nums[i] == key) 
        //        return i;
        // }
        // return -1;

    //     for(int i = 0; i < words.length; i++) {
    //         if(words[i].equals(key)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    //public static int getSmallest(int nums[]) {
        //int largest = Integer.MIN_VALUE; //-infinity
        //int smallest = Integer.MAX_VALUE;  //+infinity

          //for(int i = 0; i < nums.length; i++) {
        //     if(largest < nums[i]) {
        //         largest = nums[i];
        //     }
        //     if(smallest > nums[i]) {
        //         smallest = nums[i];
        //     }
        // }
        //return largest;
        //return smallest;
    //}

    // public static int binarySearch(int nums[], int key) {
    //     int start = 0, end = nums.length-1;

    //     while(start < end) {
    //         int mid = (start + end) / 2;

    //         //Comparisions
    //         if(nums[mid] == key) {
    //             return mid;
    //         }
    //         if(nums[mid] < key) {
    //             start = mid + 1; //Move right
    //         }
    //         else {
    //             end = mid - 1; //Move left
    //         }
    //     }
    //     return -1;
    // }

    // public static void reverseArray(int nums[]) {

    //     int first = 0, last = nums.length-1;
    //     while(first < last) {
    //         //Swap
    //         int temp = nums[first];
    //         nums[first] = nums[last];
    //         nums[last] = temp;

    //         first++;
    //         last--;
    //     }
    // }

    // public static void printPairs(int nums[]) {
    //     int tp = 0;
    //     for(int i = 0; i < nums.length; i++) {
    //         int curr = nums[i]; //2, 4, 6, 8, 10
    //         for(int j = i + 1; j < nums.length; j++) {
    //             System.out.print("(" + nums[i] + "," + nums[j] + ")");
    //             tp++;
    //         }
    //         System.out.println();
    //     }
    //     System.out.println("Total pairs = " + tp);
    // }

    // public static void printSubArrays(int nums[]) {
    //     int sum = 0;
    //     int minVal = Integer.MAX_VALUE; //+infinity
    //     int maxVal = Integer.MIN_VALUE;
    //     for(int i = 0; i<nums.length; i++) {
    //         int start = i;
    //         for(int j = i; j < nums.length; j+=1) {
    //             int end = j;
    //             for(int k = start; k <= end; k++) { //Print
    //                 System.out.print("[" +nums[k] + "]"); //Subarray
    //                 sum = sum + nums[k];
    //             }
    //             System.out.println(" Sum = " +sum);

    //             //Minimum
    //             if(minVal > sum) {
    //                 minVal = sum;
    //             }
    //             //System.out.println("Minimum Value is " +minVal);
    //             //Maximum
    //             if(maxVal < sum) {
    //                 maxVal = sum;
    //             }
    //             // System.out.println("Maximum Value is " +maxVal);
    //             sum = 0;
    //             System.out.println();
    //         }
    //         System.out.println();
    //     }

    //      System.out.println("Minimum Value is " +minVal); 
    //     System.out.println("Maximum Value is " +maxVal);
    //     System.out.println("Total Subarrays = " +(nums.length*(nums.length+1))/2);
    // }

    public static boolean duplicateElement(int nums[]) {

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
               if(nums[i] == nums[j]) {
                return true;
               }
            }
        }
        return false;
    }

    public static int searchInsertPosition(int nums[], int target) {
        int low = 0, high = nums.length-1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high+1; 
    }

    public static void main(String args[]) {

        // int nums[] = {2, 4, 6, 9, 11};
        int nums[] = {1, 2, 4, 5, 7, 9};
        int target = 2;
        System.out.println(searchInsertPosition(nums, target));
        //System.out.println(duplicateElement(nums));

        // reverseArray(nums);

        // for(int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();

        //int nums[] = {2, 4, 6, 8, 10, 12};
        //printPairs(nums);
        //printSubArrays(nums);
        // int key = 12;

        // int index = linearSearch(nums, key);
        // int index = binarySearch(nums, key);

        // String words[] = {"Dosa", "Idli", "Samosa", "Vada", "Appam", "Frooti"};
        // String key = "Vada";

        // int index = linearSearch(words, key);
        
        // if(index == -1) {
        //     System.out.println("Search Unsuccessful, NOT found");
        // }
        // else{
        //     System.out.println("Search Successful, Key is found at index " +index);
        // }

        // int marks[] = {88, 86, 98};
        // update(marks);

        //Print our marks
        // for(int i = 0; i < marks.length; i++) {
        //     System.out.print(marks[i] + " ");
        // }
        // System.out.println();

        //Scanner sc = new Scanner(System.in);

        // marks[0] = sc.nextInt();  //Phy
        // marks[1] = sc.nextInt(); //Chem
        // marks[2] = sc.nextInt(); //Math

        // System.out.println("Physics: "+ marks[0]);
        // System.out.println("Chemistry: "+ marks[1]);
        // System.out.println("Maths: "+ marks[2]);

        // int percentage = (marks[0] + marks[1] + marks[2]) / 3;
        // System.out.println("Percentage = " +percentage +"%");

        // System.out.println("Length of an array: " +marks.length);

        //int nums[] = {1, 2, 6, 3, 5};

        //int res = getLargest(nums);
        // int res = getSmallest(nums);
        // System.out.println("Smallest value is " +res);
    }
}