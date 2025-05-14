import java.util.*;
import java.util.LinkedList;
import java.util.HashMap;

public class Hashmap {

    static class HashMap<K, V> { // <K, V> are generics
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // total number of nodes
        private int N; // total number of buckets
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            N = 2 * N;
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            n = 0;
            for (LinkedList<Node> bucket : oldBuckets) {
                for (Node node : bucket) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                buckets[bi].get(di).value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                return buckets[bi].get(di).value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> bucket : buckets) {
                for (Node node : bucket) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    // Valid Anangram
    public static boolean isAnagram(String S, String T) {
         if(S.length() != T.length()) return false;

        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        // Decrease frequency based on characters in T
        for(int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            if(!mpp.containsKey(ch)) return false;
            mpp.put(ch, mpp.get(ch) - 1);
            if(mpp.get(ch) == 0) mpp.remove(ch);
        }

        // If map is empty, it's an anagram
        return mpp.isEmpty();
    }

    public static void main(String args[]) {

        // Creation
        HashMap<String, Integer> mpp = new HashMap<>();

        // Insertion -> O(1)
        mpp.put("India", 120);
        mpp.put("China", 150);
        mpp.put("USA", 50);
        mpp.put("Nepal", 20);
        mpp.put("England", 30);

        ArrayList<String> keys = mpp.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        LinkedHashMap<String, Integer> lhmp = new LinkedHashMap<>();

        // Insertion
        lhmp.put("India", 100);
        lhmp.put("China", 150);
        lhmp.put("USA", 50);

        TreeMap<String, Integer> tmp = new TreeMap<>();

        // Insertion
        tmp.put("India", 100);
        tmp.put("China", 150);
        tmp.put("USA", 50);

        // Print
        System.out.println(tmp);

        // Get-O(1)
        // System.out.println(mpp.get("Bangladesh"));

        // ContainsKey - O(1)
        // boolean isContains = mpp.containsKey("USA");
        // System.out.println(isContains);

        // Remove - O(1)
        // System.out.println(mpp.remove("China"));
        // System.out.println(mpp);

        // size - O(1)
        // System.out.println(mpp.size());

        // IsEmpty - O(1)
        // mpp.clear(); //Clears whole hashmap
        // System.out.println(mpp.isEmpty());

        // Iterate
        // Set<String> keys = mpp.keySet();
        // System.out.println(keys);

        // for (String k : keys) {
        // System.out.println("Key=" +k+ ", Value=" +mpp.get(k));
        // }

        // Majority Element-II
        int arr[] = { 1, 3, 5, 2, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
            // Else only this one line
            // hm.put(num, hm.getOrDefault(num, 0) + 1); // cleaner way
        }
        // Set<Integer> keySet = hm.keySet();

        // Print elements appearing more than n/3 times
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > arr.length / 3) {
                System.out.println("Majority element > n/3: " + key);
            }
        }

        // Valid Anagram
        String S = "heart";
        String T = "earth";

       System.out.println(isAnagram(S, T));
    }
}
