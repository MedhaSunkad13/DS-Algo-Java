import java.util.ArrayList;
//import java.util.Collections;

class ArrayLists {

    //Brute Force -> O(n^2)
    public static int containerWithWater1(ArrayList<Integer>height) { 
        int maxWater = 0;

        for(int i = 0; i < height.size(); i++) {
            for(int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = ht * width;
                maxWater = Math.max(currWater, maxWater);
            }
        }
        return maxWater;
    }

    //Optimized Appraoch -> O(n)
    public static int containerWithWater(ArrayList<Integer>height) {
        int maxWater = 0;
        int leftPtr = 0, rightPtr = height.size()-1;

        while(leftPtr < rightPtr) {
            //Calculate Ar of water
            int ht = Math.min(height.get(leftPtr), height.get(rightPtr));
            int wid = rightPtr - leftPtr;
            int currWater = ht * wid;
            maxWater = Math.max(maxWater, currWater);

            //Update ptr
            if(height.get(leftPtr) < height.get(rightPtr)) {
                leftPtr++;
            }
            else{
                rightPtr--;
            }

        }
        return maxWater;
    }

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    //Brute Force -> O(n^2)
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //2-Pointer approach -> O(n)
    public static boolean pairSum1Optimized(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size()-1;

        while(low < high) {
            //Case-1
            if(list.get(low) + list.get(high) == target) {
                return true;
            }
            //Case-2
            if(list.get(low) + list.get(high) > target) {
                high--;
            }
            else{
                low++;
            }
        }
        return false;
    }

    //Optimized Approach -> 2 Pointer Modular Arithmetic(O(n))
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int n = list.size();
        int brkPt = -1;
        
        // Find breaking point (Pivot index in rotated sorted array)
        for (int i = 0; i < n - 1; i++) { 
            if (list.get(i) > list.get(i + 1)) {
                brkPt = i;
                break;
            }
        }

        int leftPtr = (brkPt + 1) % n; // Smallest element
        int rightPtr = brkPt;          // Largest element

        while (leftPtr != rightPtr) { 
            int sum = list.get(leftPtr) + list.get(rightPtr);

            // Case 1: Pair found
            if (sum == target) {
                return true;
            }

            // Case 2: Move leftPtr forward (circular)
            if (sum < target) {
                leftPtr = (leftPtr + 1) % n;
            }

            // Case 3: Move rightPtr backward (circular)
            else {
                rightPtr = (n + rightPtr - 1) % n;
            }
        }
        return false;
    }
        
    public static boolean isMonotonic(ArrayList<Integer> list2) {
        boolean increasing  = true, decreasing = true;
        for(int i = 0; i < list2.size()-1; i++) {
            //Case:1
            if(list2.get(i) > list2.get(i+1)) {
                increasing = false;
            }
            //Casse:2
            if(list2.get(i) < list2.get(i+1)) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    

    public static void main(String []args) {
        //ArrayList<Integer> height = new ArrayList<>();
        // ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        list3.add(1);
        list3.add(3);
        list3.add(5);
        list3.add(3);
        
        list2.add(1);
        list2.add(5);
        list2.add(3);
        list2.add(4);
        //System.out.println(isMonotonic(list2));
        
        //Sorted and Rotated Array
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        // int target = 16;
        // System.out.println(pairSum2(list, target));

        //[1, 8, 6, 2, 5, 4, 8, 3, 7]
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // System.out.println(containerWithWater(height));

        //System.out.println(pairSum1(list, target));

        //ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // for(int i = 1; i <= 5; i++) {
        //     list1.add(i * 1); //1, 2, 3, 4, 5
        //     list2.add(i * 2); // 2, 4, 6, 8, 10
        //     list3.add(i * 3); // 3, 6, 9, 12, 15
        // }

        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);

        // for(int i = 0; i < mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j = 0; j < currList.size(); j++) {
        //         System.out.print(currList.get(j)+" ");
        //     }
        //     System.out.println();
        // }
        //System.out.print(mainList);

        // list.add(1);
        // list.add(2);
        // list.add(3);
        // mainList.add(list);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(6); list2.add(8);
        // mainList.add(list2);

        // for(int i = 0; i < mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j = 0; j < currList.size(); j++) {
        //         System.out.print(currList.get(j) + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.print(mainList);

        // list.add(2);
        // list.add(5); //O(1)
        // list.add(9);
        // list.add(7);
        // list.add(4);

        // System.out.println(list1);
        // System.out.println(list);

        // int idx1 = 1, idx2 = 3;
        // System.out.println(list);
        // swap(list, idx1, idx2);
        // System.out.println(list);

        //list.add(1, 9);
        // int n = list.size();
        // System.out.println(n);

        // System.out.println(list);
        //Collections.sort(list);
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        //Get Operation
        //System.out.println(list.get(2));

        //Delete
        // list.remove(2);
        // System.out.println(list);

        //Set Element
        // list.set(2, 10);
        // System.out.println(list);

        //Contains element
        // System.out.println(list.contains(10));
        // System.out.println(list.contains(6));

        //Iteration of AL
        // for(int i = 0; i < n; i++) {
        //     System.out.print(list.get(i)+" ");
        // }
        // System.out.println();

        //Reversing an AL
        // for(int i = n-1; i >= 0; i--) {
        //     System.out.print(list.get(i) + " ");
        // }
        // System.out.println();

        // int max = Integer.MIN_VALUE;
        // for(int i = 0; i < n; i++) {
        //     if(list.get(i) > max) {
        //         max = list.get(i);
        //     }
        // }
        // System.out.println("Maximum Element: " + max);
    }
}