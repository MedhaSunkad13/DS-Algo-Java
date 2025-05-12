import java.util.*;

public class PriorityQ {

    static class Student implements Comparable<Student> { // Overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(log n)
            // Add at last index
            arr.add(data);

            int x = arr.size() - 1; // x is child index
            int par = (x - 1) / 2; // Parent index

            while (x > 0 && arr.get(x) < arr.get(par)) { // O(log n)
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() { // O(1)
            return arr.get(0);
        }

        private void Heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                Heapify(minIdx);
            }
        }

        public int remove() { // O(log n)
            int data = arr.get(0);
            int x = arr.size() - 1;

            // Step-1: Swap first element and last element
            arr.set(0, arr.get(x));
            arr.set(x, data);

            // Step-2: Delete last element
            arr.remove(x);

            // Step-3: Heapify
            Heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void heapSort(int arr[]) {
        // Step-1: To build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Step-2: To push largest at end
        for (int i = n - 1; i > 0; i--) {
            // Swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void heapify(int arr[], int i, int sz) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i; // change maxIdx -> minIdx every where

        // Change arr[left] < arr[minIdx] to sort in descending order
        if (left < sz && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        // Change arr[right] < arr[maxIdx] to sort in descending order
        if (right < sz && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // Swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, sz);
        }
    }

    // Nearby Cars
    static class Point implements Comparable<Point> {
        int x, y;
        int disSqr;
        int idx;

        public Point(int x, int y, int disSqr, int idx) {
            this.x = x;
            this.y = y;
            this.disSqr = disSqr;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.disSqr - p2.disSqr;
        }
    }

    // Weakest Soldier
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    // Sliding window maximum using Priority Queue and maxHeap
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // Ascending order
            // return this.val = p2.val;
            // To sort in descending order opposite condition of ascending order
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // PriorityQueue<Student> pq = new PriorityQueue<>();

        // Insertion //O(log n)
        // pq.add(3);
        // pq.add(2);
        // pq.add(1);
        // pq.add(8);

        // while(!pq.isEmpty()) {
        // //Peek
        // System.out.print(pq.peek()+" "); //O(1)
        // Highest Priority element will be printed and then removed

        // Deletion
        // pq.remove(); //O(log n);
        // }

        // pq.add(new Student("A", 4));
        // pq.add(new Student("B", 5));
        // pq.add(new Student("C", 1));
        // pq.add(new Student("D", 11));

        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek().name + "->" + pq.peek().rank);
        // pq.remove();
        // }

        // 2. Custom Heap with Integers
        // Heap h = new Heap();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);

        // System.out.println("Custom Min-Heap (Integers):");
        // while (!h.isEmpty()) {
        // System.out.println(h.peek());
        // h.remove();
        // }

        // Heap Sort
        int arr[] = { 1, 2, 4, 5, 3 };

        // heapSort(arr);
        // Print elements
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            // disSqr = x^2 + y^2;
            int disSqr = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], disSqr, i));
        }
        // Nearest K cars
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }

        // Connect N ropes
        int ropes[] = { 2, 3, 3, 4, 6 };
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        int n = ropes.length;
        for (int i = 0; i < n; i++) {
            pque.add(ropes[i]);
        }

        int cost = 0;
        while (pque.size() > 1) {
            int min = pque.remove();
            int min2 = pque.remove();
            cost += min + min2;
            pque.add(min + min2);
        }
        System.out.println("Cost of connecting " + n + " ropes = " + cost);

        int[][] army = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };
        int K = 2;

        PriorityQueue<Row> prq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int cnt = 0;
            for (int j = 0; j < army[0].length; j++) {
                cnt += army[i][j] == 1 ? 1 : 0;
            }
            prq.add(new Row(cnt, i));
        }
        for (int i = 0; i < K; i++) {
            System.out.print("R" + prq.remove().idx + " ");
        }
        System.out.println();

        // Sliding window maximum using Priority Queue and maxHeap O(NLogSize)
        int ar[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int size = 3; // Window size
        int res[] = new int[arr.length - 1 + size];

        PriorityQueue<Pair> prque = new PriorityQueue<>();

        //1st window
        for(int i = 0; i < size; i++) {
            prque.add(new Pair(ar[i], i));
        }

        res[0] = prque.peek().val;

        for(int i = size; i < ar.length; i++) {
            while (prque.size() > 0 && prque.peek().idx <= (i-size)) {
                prque.remove();
            }

            prque.add(new Pair(ar[i], i));
            res[i-size+1] = prque.peek().val;
        }

        //Print result
        for(int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }
        System.out.println();
    }
}
