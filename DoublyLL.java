
public class DoublyLL {
    
    public class  Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    //Add
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        //Base case
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        newNode.prev = null; 
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        //Base case
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        newNode.next = null;
    }

    //Remove
    public int removeFirst() {
        if(head == null) {
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        }

         if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
         }
       
           int val = head.data;
           head = head.next; // Move head to the next node
           head.prev = null; // Remove backward reference
           size--;
           return val;
    }

    public int removeLast() {
        if(head == null) {
            System.out.println("LinkedList is Empty.");
            return Integer.MIN_VALUE;
        }

        if(size == 1) {
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    //Reverse
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    
    //Print
    public void print() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        //System.out.println(dll.size);

        //dll.removeFirst();
        //dll.removeLast();
        //dll.reverse();
        dll.print();
        //System.out.println(dll.size);
    }
}
