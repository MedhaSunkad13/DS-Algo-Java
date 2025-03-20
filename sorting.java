//import java.util.*;

public class sorting {

    public static void bubbleSort(int nums[]) {
        int swaps = 0;
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = 0; j < nums.length-1-i; j+=1) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0) {
                break;
            }
        }
        System.out.println(swaps);
    }

    public static void selectionSort(int nums[]) {
        for(int i = 0; i < nums.length-1; i++) {
            int minPos = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }
            //Swap
            int temp = nums[minPos];
            nums[minPos] = nums[i];
            nums[i] = temp;
        }
    }

    public static void insertionSort(int nums[]) {
        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = i - 1;

            while(prev >= 0 && nums[prev] > curr) {
                nums[prev + 1] = nums[prev];
                prev--;
            }
            //Insertion
            nums[prev + 1] = curr;
        }
    }

    public static void countingSort(int nums[]) {
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }
        int count[] = new int[largest + 1];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        //sorting
        int j = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                nums[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void bubble(int arr[]) {
        int swaps = 0;
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0) break;
        }
        System.out.println("Number of swaps : " +swaps);
    }

    public static void selection(int arr[]) {
        for(int i = 0; i < arr.length-1; i++) {
            int mini = i;
            for(int j = i+1; j < arr.length-1; j++) {
                if(arr[j] > arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertion(int arr[]) {
        for(int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while(prev >= 0 && arr[prev] < curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
              arr[prev+1] = curr;
        }
    }

        public static void printArray(int arr[]) {
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public static void main(String args[]) {
        //int nums[] = {13, 20, 25, 42, 6, 15};
        int arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        //bubbleSort(nums);
        //selectionSort(nums);
        //insertionSort(nums);
        //bubble(arr);
        insertion(arr);
        selection(arr);
        printArray(arr);
     }

}