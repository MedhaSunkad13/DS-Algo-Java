import java.util.HashSet;

public class RecursionAdv {

   public static int tilingProblem(int n) { //2 x n ->(floor size)
    //Base case
    if(n == 0 || n == 1) {
        return 1;
    }

    //Vertical choice
    // int verticalTile = tilingProblem(n-1);

    // //Horizontal Tile
    // int horizontalTile = tilingProblem(n-2);

     //Total Ways
    //  int totWays = verticalTile + horizontalTile;
    //  return totWays;

    return tilingProblem(n-1) + tilingProblem(n-2);
   }

    public static void removeStrDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
    if (idx == str.length()) {
        System.out.println(newStr);
        return;
    }

    char currChar = str.charAt(idx);
    if (map[currChar - 'a']) {
        // Duplicate
        removeStrDuplicates(str, idx + 1, newStr, map);
    } else {
        map[currChar - 'a'] = true;
        removeStrDuplicates(str, idx + 1, newStr.append(currChar), map);
    }
}

    public static int friendsPairing(int n) {
        //Base case
        if(n == 1 || n == 2) {
            return n;
        }

        //Work, Choice
        //Single
        // int fnm1 = friendsPairing(n-1);

        // //Pair
        // int fnm2 = friendsPairing(n-2);
        // int pairWays = (n-1) * fnm2;

        // //Total Ways
        // int totWays = fnm1 + pairWays;
        // return totWays;

        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    public static void printBinaryStrings(int n, int lastPlace, String str) {
        //Base Case
            if(n == 0) {
              System.out.println(str);
              return;
            }

        //Work
        printBinaryStrings(n-1, 0, str+"0");
        
        if(lastPlace == 0) {
            printBinaryStrings(n-1, 1, str+"1");
        }

    }

   public static void countOccurrences(int arr[], int target, int i) {
    // Base Case
    if (i == arr.length) {
        return;
    }
    // Print index if target is found
    if (arr[i] == target) {
        System.out.print(i + " ");
    }
    // Recursive call
    countOccurrences(arr, target, i + 1);
   }

    public static int findStrLen(String str, int i) {

        // char ch[] = str.toCharArray();

        // if(i == ch.length) {
        //     System.out.print(i);
        //     return;
        // }

        // findStrLen(str, i+1);
        if (i == str.length()) {
        return i;
      }

        // Recursive Call
        return findStrLen(str, i + 1);
    }
    
    public static int countSubStr(String str, int i, int j) {
    if (i == str.length()) {
        return 0;
    }

    if (j == str.length()) {
        return countSubStr(str, i + 1, i + 1);  //j = i + 1
    }

    int count = 0;
    if (str.charAt(i) == str.charAt(j)) {
        count = 1;  
    }

    return count + countSubStr(str, i, j + 1);
}

// public static void print5To1(int n) {
//     if(n == 1) {
//         System.out.print(n);
//         return;
//     }

//     System.out.print(n + " ");
//     print5To1(n-1);
// }

public static void towerOfHanoi(int n, String src, String helper, String dest) {
    //Base Case
   if(n == 1) {
    System.out.println("Move disk " + n + " from " + src + " to " +dest);
    return;
   }

    towerOfHanoi(n-1, src, dest, helper);
    System.out.println("Move disk " + n + " from " + src + " to " +dest);
    towerOfHanoi(n-1, helper, src, dest);
}

public static void printRevStr(String str, int idx) {
    //Base Case
    if(idx == 0) {
        System.out.print(str.charAt(idx));
        return;
    }
    System.out.print(str.charAt(idx));
    printRevStr(str, idx-1);
}

public static int first = -1;
public static int last = -1;

public static void findOccurrence(String str, int i, char key) {
    //Base case
     if (i == str.length()) {
        System.out.println("First: " + first);
        System.out.println("Last: " +last);
        return;
    }

    char currChar = str.charAt(i);
    if(currChar == key) {
        if(first == -1){
            first = i;
        }
        else {
            last = i;
        }
    }
    findOccurrence(str, i+1, 'a');
}

//My approach
public static int firstOccofChar(String str, int i, char target) {
    //Base Case 
    if(i == str.length()) {
        return -1;
    }
    if(str.charAt(i) == target) {
        return i;
    }
    return firstOccofChar(str, i+1, 'a');

}

public static boolean isSorted(int arr[], int i) {
    //Base case
    if(i == arr.length-1) {
        return true;
    }

    if(arr[i] > arr[i+1]) {
        return false;
    }
    return isSorted(arr, i+1);
}

public static void moveAllX(String str, int idx, int cnt, String newStr) {
    //Base case
    if(idx == str.length()) {
        for(int i = 0; i < cnt; i++) {
            newStr += 'x';
        }
        System.out.println(newStr);
        return;
    }

    char currChar = str.charAt(idx);
    if(currChar == 'x') {
        cnt++;
        moveAllX(str, idx+1, cnt, newStr);
    }
    else {
        newStr += currChar; //newStr + currChar
        moveAllX(str, idx+1, cnt, newStr);
    }
}

  public static boolean map[] = new boolean[26];
  public static void removingStrDuplicates(String str, int idx, String newStr) {
    //Base Case
    if(idx == str.length()) {
        System.out.print(newStr);
        return;
    }

    char currChar = str.charAt(idx);
    if(map[currChar - 'a'] == true) {
        removingStrDuplicates(str, idx+1, newStr);
    }
    else {
        newStr += currChar;
        map[currChar - 'a'] = true;
        removingStrDuplicates(str, idx+1, newStr);
    }
  }

    public static void printSubSequences(String str, int idx, String newString, HashSet<String> set) {
        if (idx == str.length()) {
            if (set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char currChar = str.charAt(idx);

        // Include the current character
        printSubSequences(str, idx + 1, newString + currChar, set);

        // Exclude the current character
        printSubSequences(str, idx + 1, newString, set);
    }

    public static String[] keyPad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void printComb(String str, int idx, String combination) {
        //Base Case
        if(idx == str.length()) {
            System.out.println(combination);
            return;
        }

        char currChar = str.charAt(idx);
        String mapping = keyPad[currChar - '0'];

        for(int i = 0; i < mapping.length(); i++) {
            printComb(str, idx+1, combination+mapping.charAt(i));
        }
    }

    public static void main(String args[]) {
             //int n = 3;
            //towerOfHanoi(n, "S", "H", "D");
           //System.out.println(tilingProblem(6));
          //String str = "appnnacollege";
         //removeStrDuplicates(str, 0, new StringBuilder(" "), new boolean[26]);
         //System.out.println(friendsPairing(3));
        // printBinaryStrings(3, 0, " ");
        // int arr[ ] = {3, 5, 4, 5, 6, 2, 7, 5, 4};
        // countOccurrences(arr, 5, 0);
        // String str = "medha";
        // System.out.println("Length: " + findStrLen(str, 0)); 
        // String str = "abcab";
        // int result = countSubStr(str, 0, 0);
        // System.out.println("Count of substrings that start and end with the same character: " + result);
        // print5To1(5);
        //String str = "abaacdaefaah";
        // int idx = str.length()-1;
        // printRevStr(str, idx);
        // System.out.print(firstOccofChar(str, 0, 'a'));
        //findOccurrence(str, 0, 'a');
        // int arr[] = {1, 2, 3, 4, 5, 3};
        // System.out.println(isSorted(arr, 0));
        // String str = "axbcxxd";
        // moveAllX(str, 0, 0, " ");
        // String str = "abbcddea";
        // removingStrDuplicates(str, 0, " ");
        // String str = "aaa";
        // HashSet<String> set = new HashSet<>();  // Initializing the HashSet
        // printSubSequences(str, 0, "", set);
        String str = "6";
        printComb(str, 0, " ");
    }
}