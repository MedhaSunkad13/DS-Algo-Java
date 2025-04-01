
public class GreedyAssignment {
  
        public static int maxBalancedSubstrings(String str) {
            int count = 0;  
            int ans = 0;  
    
            for (int i = 0; i < str.length(); i++) {  
                if (str.charAt(i) == 'L') { 
                    count++;
                } else {
                    count--;
                }
    
                if (count == 0) { // Found a balanced substring
                    ans++;
                }
            }
            return ans;
        }
    
        public static int findKthLargestOdd(int L, int R, int K) {
            // Find the largest odd number in range
            if (R % 2 == 0) {
                R--; // Make R odd
            }
    
            // Calculate the Kth largest odd number
            int kthLargestOdd = R - 2 * (K - 1);
    
            // Check if it falls within the range
            if (kthLargestOdd < L) {
                return -1; // Not found
            }
            return kthLargestOdd;
        }
    
        public static String findSmallestString(int N, int K) {
            char[] result = new char[N];
            
            // Step 1: Fill the string with 'a' (each has value 1)
            for (int i = 0; i < N; i++) {
                result[i] = 'a';
            }
    
            // Step 2: Compute remaining sum needed
            int remaining = K - N;
            
            // Step 3: Start replacing from the rightmost position
            int index = N - 1; // Start from the last character
            while (remaining > 0) {
                int add = Math.min(remaining, 25); // Max we can add is 'z' - 'a' (25)
                result[index] += add; // Increase character value
                remaining -= add;
                index--; // Move left
            }
    
            return new String(result);
        }

        public static void main(String[] args) {
            String str = "LLRRLRLRLLRR";
            System.out.println("Maximum Balanced Substrings: " + maxBalancedSubstrings(str));

            int L = 3, R = 15, K = 3;  // Example input
            int result = findKthLargestOdd(L, R, K);

        if (result == -1) {
            System.out.println("Kth largest odd number not found in the range.");
        } else {
            System.out.println("Kth largest odd number: " + result);
        }
        int N = 5, K = 42; 
        System.out.println("Lexicographically smallest string: " + findSmallestString(N, K));
    }
}
    
