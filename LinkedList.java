
public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }  

    private static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
      //Step-1 Create new node
      Node newNode = new Node(data);
      size++;
      if(head == null) {
        head = tail = newNode;
        return;
      }
      
      //Step-2 newNode->next = head;
        newNode.next = head; //link

        //Step-3 head = newNode
        head = newNode; 
    }

    public void addLast(int data) {
      //Create a new Node
      Node newNode = new Node(data);
      size++;

      if(head == null) {
        head = tail = newNode;
        return;
      }

        //tail->next = newNode
        tail.next = newNode;

        //newNode becomes tail
        tail = newNode;
    }

    public void addMid(int data, int idx) {
      //To insert at beg
      if(idx == 0) {
        addFirst(data);
        return;
      }
      //Create new Node
      Node newNode = new Node(data);
      size++;
      Node temp = head;
      int i = 0;

      //To find prev of newNode
      while(i < idx-1) {
        temp = temp.next;
        i=i+1;
      }
      //i->idx-1, temp->prev
      newNode.next = temp.next;
      temp.next = newNode;
    }

    public int removeFirst() {
      if(size == 0) {
        System.out.println("LinkedList is empty.");
        return Integer.MIN_VALUE;
      }
      else if(size == 1) {
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
      }
      int val = head.data;
      head = head.next;
      size--;
      return val;
    }

    public int removeLast() {
      if(size == 0) {
        System.out.println("LinkedList is Empty.");
        return Integer.MIN_VALUE;
      }
      else if(size == 1){
        int val = tail.data;
        head = tail = null;
        size = 0;
        return val;
      }
      //prev-> i = size-2
      Node prev = head;
      for(int i = 0; i < size-2; i++) {
        prev = prev.next;
      }
      int val = prev.next.data; //tail.data
      prev.next = null;
      tail = prev;
      size--;
      return val;
    }

    public int itrSearch(int key) {
      Node tmp = head;
      int i = 0;

      while (tmp != null) {
        if(tmp.data == key) {
          return i; //Key found
        }
        tmp = tmp.next;
        i+=1;
      }
      //Key not found
      return -1;
    }

    public int helperFun(Node head, int key) {
      if(head == null) {
        return -1;
      }

      if(head.data == key) {
        return 0;
      }
      int idx = helperFun(head.next, key);
      if(idx == -1) {
        return -1;
      }
      return idx+1;
    }

    public int recSearch(int key) {
      return helperFun(head, key);
    }

    public void revIterative() {
      //Edge Case
      if(head == null || head.next == null) {
        return;
      }

      Node prevNode = head;
      Node currNode = head.next;

      while(currNode != null) {
        Node nextNode = currNode.next;
        currNode.next = prevNode;

        //Updation
        prevNode = currNode;
        currNode = nextNode;
      }
      head.next = null;
      head = prevNode;
    }

    public Node revRecursive(Node head) {
      //Base Case:
      if(head == null || head.next == null) {
        return head;
      }

      Node newHead = revRecursive(head.next);
      head.next.next = head;
      head.next = null;
      
      return newHead;
    }

    //Striver
    public Node revRecursive2(Node head) {
         // Base Case: if list is empty or only 1 node
          if (head == null || head.next == null) {
            return head;
          }

          Node newHead = revRecursive(head.next);
          Node nextPtr = head.next;
          nextPtr.next = head;
          head.next = null;
          return newHead; 
    }

    public void deleteNthFromEnd(int n) {
      //Calculate size
      int size = 0;
      Node temp = head;
      while (temp != null) {
        temp = temp.next;
        size++;
      }
      
      if(n == size) {
        head = head.next; //removeFirst
        return;
      }

      //size-n
      int i = 1;
      int iToFind = size - n;
      Node prev = head;
      while (i < iToFind) {
        prev = prev.next;
        i++;
      }
      prev.next = prev.next.next;
      return;
    }

    //Slow-fast Approach
    public Node findMid(Node head) {
      Node slow = head;
      Node fast = head;
  
      while (fast != null && fast.next != null) {  
          slow = slow.next;  // Move slow by 1 step
          fast = fast.next.next;  // Move fast by 2 steps
      }
  
      return slow;  // slow is now at the middle node
  }
  
    public boolean isPalindrome() {
      // Base Case: if list is empty or only 1 node
      if (head == null || head.next == null) {
        return true;
      }
      //Step-1 -> findMid
      Node midNode = findMid(head);

      //Step-2 -> Reverse secHalf
      Node prev = null;
      Node curr = midNode;
      Node next;
      while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }

      Node right = prev; //(Back)right half head
      Node left = head;
      //Step-3 -> compare leftHalf & rightHalf
      while (right != null) {
        if(left.data != right.data) {
          return false;
        }
          left = left.next;
          right = right.next;
      }
      return true;
    }

    //Floyd's Cycle detection Algorithm
    public static boolean detectCycle() {
      Node slow = head;
      Node fast = head; 

      while (fast != null && fast.next != null) {
        slow = slow.next; //1x
        fast = fast.next.next; //2x

        if(slow == fast) {
          return true; //cycle exists
        }
      }
      return false;//Cycle does'nt exist
    }

    public static void removeCycle() {

      Node slow = head;
      Node fast = head;
      boolean cycle = false;

      //Detect cycle
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast) {
          cycle = true;
          break;
        }
      }
      if(cycle == false) {  // No cycle found
        return;
      }

        //Find meeting point
        slow = head;
        Node prev = null; // This will track the last node before cycle starts

        while (slow != fast) {
          prev = fast;
          slow = slow.next;
          fast = fast.next;
        }

        // Step 3: Remove cycle
        //if (prev != null) {
            prev.next = null; // Break the cycle
        //}
    }

    private Node Merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // Dummy node
        Node temp = mergedLL;

      while (head1 != null && head2 != null) {
          //Left Part Merging
          if(head1.data <= head2.data) {
              temp.next = head1;
              head1 = head1.next;
              temp = temp.next;
          }
          else { //Right part merging
              temp.next = head2;
              head2 = head2.next;
              temp = temp.next;
          }
      }

      while (head1 != null) {
          temp.next = head1;
          head1 = head1.next;
          temp = temp.next;
      }

      while (head2 != null) {
          temp.next = head2;
          head2 = head2.next;
          temp = temp.next;
      }
      return mergedLL.next; 
  }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //Mid
    }

    public Node mergeSortOnLL(Node head) {
        // Base Case: if list is empty or only 1 node
        if (head == null || head.next == null) {
            return head;
          }

        //Find Mid
        Node mid = getMid(head);

        //Left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSortOnLL(head);
        Node newRight = mergeSortOnLL(rightHead);

        //Merge
        return Merge(newLeft, newRight);
    }

    public void zigZag() {
      //Find mid
      Node slow = head;
      Node fast = head.next;

      while (fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }

      Node mid = slow;

      //Reverse 2nd half
      Node curr = mid.next;
      mid.next = null;
      Node prev = null;
      Node next;

      while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }

      Node left = head;
      Node right = prev;
      Node nxtL, nxtR;

      //Zig-Zag Merge
      while (left != null && right != null) {
        nxtL = left.next;
        left.next = right;
        nxtR = right.next;
        right.next = nxtL;

        //Update
        left = nxtL;
        right = nxtR;
      }
    }

    public Node addLast2(Node head, int data) {
      //New Node
      Node newNode = new Node(data);
      size++;
      if(head == null) {
        return new Node(data);
      }

      //Adding at last
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
        temp.next = newNode;
        newNode.next = null;

        return head;
    }

    //Assignment
    public Node deleteNNodes(Node head, int M, int N) {
      if (head == null || M == 0) {
          return null;  
      }
      if (N == 0) {
          return head;  
      }

      Node temp = head;

      while (temp != null) {
          // Retain M nodes
          for (int i = 1; i < M && temp != null; i++) {
              temp = temp.next;
          }

          if (temp == null) {
              break; 
          }

          // Delete N nodes
          Node deleteNode = temp.next;
          for (int i = 0; i < N && deleteNode != null; i++) {
              deleteNode = deleteNode.next;
          }

          // Update links to skip the deleted nodes
          temp.next = deleteNode;

          // Move temp forward
          temp = deleteNode;
      }
      return head;
  }

    public void print() { //O(n)
      if(head == null) {
          System.out.println("LinkedList is Empty.");
          return;
      }
  
      Node temp = head;
      while(temp != null) { 
          System.out.print(temp.data + "->");
          temp = temp.next;
      }
      System.out.println("null");
  }
    
    public static void main(String[] args) {
      // head = new Node(1);
      // Node temp = new Node(2);
      // head.next = temp;
      // head.next.next = new Node(3);
      // head.next.next.next = temp;

      // System.out.println(detectCycle());
      // removeCycle();
      // System.out.println(detectCycle());

      LinkedList ll = new LinkedList();
      // ll.head = new Node(1);
      // ll.head.next = new Node(2); //Methods
      // ll.addLast(1);
      // ll.addLast(2);
      // ll.addLast(2);
      // ll.addLast(3);
      ll.addLast(1);
      ll.addLast(2);
      ll.addLast(3);
      ll.addLast(4);
      //ll.addMid(3, 2); 
      ll.print(); //1->2->3->4->5->6->7->8

        //ll.head = ll.mergeSortOnLL(ll.head);
        //ll.zigZag();
        //head = ll.deleteNNodes(head, 2, 2);
        ll.addLast2(head, 5);
        ll.print();
      
      //System.out.println("Original Linked List: ");
      // ll.print(); //1->2->2->1
      // System.out.println(ll.isPalindrome());
      // ll.removeFirst();
      // ll.removeLast();
      // ll.revIterative();
      //ll.head = ll.revRecursive2(ll.head);
      // ll.deleteNthFromEnd(3);
      // ll.print();
      // System.out.println(ll.itrSearch(3));
      // System.out.println(ll.itrSearch(9));

      // System.out.println(ll.recSearch(3));
      // System.out.println(ll.recSearch(9));
      //System.out.println("Size of LL: " +size);
    }
}
