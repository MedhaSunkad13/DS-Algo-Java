import java.util.*;
import java.util.LinkedList;

public class PracticeQue {
    
    public static void printFirstNonRepeating(String str) {
        int freq[] = new int[26]; //'a' - 'z'
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            }
            else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i = 0; i < size/2; i++) {
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    // public static void reverseQueue(Queue<Integer> q) {
         //Stack<Integer> s = new Stack<>();

    //     while (!q.isEmpty()) {
    //         s.push(q.remove()); //Push into stack
    //     }

    //     while (!s.isEmpty()) {
    //         q.add(s.pop());
    //     }
    // }

    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        //Pop
        public int pop() {
            return deque.removeLast();
        }

        //Peek
        public int peek() {
            return deque.getLast();
        }
    }

    static class Queue1 {
        Deque<Integer> deque = new LinkedList<>();

        //Add
        public void add(int data) {
            deque.addLast(data);
        }

        //Remove
        public int remove() {
            return deque.removeFirst();
        }

        //Peek
        public int peek() {
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        // String str = "aabccxb";
        // printFirstNonRepeating(str);

        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        //interLeave(q);
        // while (!q.isEmpty()) {
        //     System.out.print(q.remove() + " ");
        // }
        // System.out.println();

        //reverseQueue(q);
        // while (!q.isEmpty()) {
        //     System.out.print(q.remove()+" ");
        // }
        // System.out.println();

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);

        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());

        Stack S = new Stack();
        S.push(1);
        S.push(2);
        S.push(3);
        System.out.println("Peek = " + S.peek());
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());

        Queue1 q = new Queue1();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Peek=" + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
