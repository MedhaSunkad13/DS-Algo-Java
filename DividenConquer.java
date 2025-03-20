//import java.util.*;

public class DividenConquer {

    public static void printArray(String arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

   public static void mergeSort(int arr[], int si, int ei) {
    // Base case:
    if (si >= ei) {
        return;
    }

    // Calculate mid
    int mid = si + (ei - si) / 2;
    mergeSort(arr, si, mid);   // Left part
    mergeSort(arr, mid + 1, ei); // Right part
    merge(arr, si, mid, ei);   // Merge step
}

   public static void merge(int arr[], int si, int mid, int ei) {
    int temp[] = new int[ei - si + 1];
    int i = si; // Iterator for left part
    int j = mid + 1; // Iterator for right part
    int k = 0; // Iterator for temp array

    while (i <= mid && j <= ei) {
        if (arr[i] < arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    // Copy remaining left part
    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    // Copy remaining right part
    while (j <= ei) {
        temp[k++] = arr[j++];
    }

    // Copy temp array back to the og array
    for (i = si, k = 0; k < temp.length; i++, k++) {
        arr[i] = temp[k];
    }
}

    public static void quickSort(int arr[], int si, int ei) {
        //Base Case:
        if(si >= ei) {
            return;
        }

        //last element
        int pivIdx = partition(arr, si, ei);
        quickSort(arr, si, pivIdx-1);
        quickSort(arr, pivIdx+1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; //to make place for eles smaller than pivot

        for(int j = si; j < ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int rotatedSearch(int arr[], int target, int low, int high) {
        //Base Case:
        if(low > high) {
            return -1;
        }

        //Calc mid
        int mid = low + (high - low) / 2;

        //Case: found at mid
        if(arr[mid] == target) {
            return mid;
        }

        //target- lie on L1
        if(arr[low] <= arr[mid]) {
            //Case:a - Left
            if( arr[low] <= target && target <= arr[mid] ) {
                return rotatedSearch(arr, target, low, mid-1);
            }
            else {
                //Case:b Right
                return rotatedSearch(arr, target, mid+1, high);
            }
        }

        //target : Lie on L2
        if(arr[mid] <= target && target <= arr[high]) {
            //Case: c -> Left
            return rotatedSearch(arr, target, mid+1, high);
        }
        else {
            //Case: d -> right
            return rotatedSearch(arr, target, low, mid-1);
        }
    }

    public static void dividenMerge(String arr[], int low, int high) {
        if(low >= high) return;
        int mid = (low + high) / 2; //Calc Mid
        dividenMerge(arr, low, mid); //left Half
        dividenMerge(arr, mid+1, high); //right Half
        Merge(arr, low, mid, high);
    }

    public static void Merge(String arr[], int low, int mid, int high) {
        String temp[] = new String[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while(left <= mid && right <= high) {
            if(arr[left].compareTo(arr[right]) <= 0) {
                temp[k++] = arr[left++];
            }
            else {
                temp[k++] = arr[right++];
            }
        }

        //If elements on left half are still left
        while(left <= mid) {
            temp[k++] = arr[left++];
        }

        //If elements on right half are still left
        while(right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy temp array back to the og array
        for(int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    public static int majorityElement(int nums[]) {
        int majorityEle = (nums.length) / 2;
        for(int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    cnt++;
                }
                if(cnt > majorityEle) {
                  return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
         //int arr[] = {6, 3, 9, 5, 2, 8};
        // int arr[] = {4, 5, 6, 7, 0, 1, 2};
        // int target = 0; //O/p => 4
        // int tarIdx = rotatedSearch(arr, target, 0, arr.length-1);
        // System.out.println(tarIdx);
        // quickSort(arr, 0, arr.length-1);
        // String arr[] = {"sun", "earth", "mars", "mercury"};
        // dividenMerge(arr, 0, arr.length-1);
        // printArray(arr);
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}