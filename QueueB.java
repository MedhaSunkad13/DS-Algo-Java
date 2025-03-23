import java.util.*;

public class QueueB {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        //Add
        public static void add(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //Remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = head.data;
            if(tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }
    
        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }
            return head.data;
        }
    }

    static class InnerQueueB {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        InnerQueueB(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        //Insert(Circular Queue)
        public static void add1(int data) { //O(1)
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }
            //add first element
            if(front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
    
        //Remove
        public static int remove1() { // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }
            int result = arr[front];
        
            if (front == rear) { // Only one element left
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }        

        //Peek
        public static int peek1() { //O(1)
            if(isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }
            return arr[front];
        }
        
        //Insert
        public static void add(int data) { //O(1)
            if(rear == size-1) {
                System.out.println("Queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }
    
        //Delete
        public static int remove() { //O(1)
            if(isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }
            int front = arr[0];
            for(int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear -= 1;
            return front;
        }

        //Peek
        public static int peek() { //O(1)
            if(isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }
            return arr[0];
        }
    
    }

    static class Queue1 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        //Add
        public static void add(int data) { //O(n)
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    
        //Remove
        public static int remove() { //O(1)
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.pop();
        }
    
        //Peek
        public static int peek() { //O(1)
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.peek();
        }
    }

    public static void main(String[] args) {
        //Queue q = new Queue();
        //Queue is an Interface so, it cannot be implemented as class
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println(q.remove1());
        // q.add(4);
        // System.out.println(q.remove1());
        // q.add(6);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        //JCF (ArrayDeque)
        // Queue<Integer> q = new LinkedList<Integer>();
        Queue1 q = new Queue1();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek()); // Prints the front element
            q.remove(); // Removes the front element
        }
   }
}
