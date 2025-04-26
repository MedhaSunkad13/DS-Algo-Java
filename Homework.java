import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Homework {

    static int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (key >= arr[low] && key <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (key >= arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int maxWater(int arr[]) {
        int low = 1, ans = 0, high = arr.length - 2;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];

        while (low <= high) {
            leftMax = Math.max(leftMax, arr[low]);
            rightMax = Math.max(rightMax, arr[high]);

            if (leftMax < rightMax) {
                ans += (leftMax - arr[low]);
                low++;
            } else {
                ans += (rightMax - arr[high]);
                high--;
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        int low = 0;
        int high = n - 1;
        int mid = high - 1;

        while (high >= 2) {
            while (low < mid) {
                int sum = nums[low] + nums[mid] + nums[high];

                if (sum == 0) {
                    set.add(Arrays.asList(nums[low], nums[mid], nums[high]));
                    low++;
                    mid--;
                } else if (sum > 0)
                    mid--;

                else
                    low++;
            }
            high--;
            mid = high - 1;
            low = 0;
        }
        result.addAll(set);
        return result;
    }

    public static void main(String args[]) {
        // int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        // int key = 7;

        int arr[] = { 3, 0, 1, 0, 4, 0, 2 };
        System.out.println(maxWater(arr));

        int nums[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

        // System.out.println(search(arr, key));
    }
}
