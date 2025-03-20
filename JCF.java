import java.util.LinkedList;

public class JCF {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    private Node Merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
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

    public static void main(String[] args) {
        //Create -> Object int, float, boolean-> Integer, Float, Character
        LinkedList<Integer> ll = new LinkedList<>();

        //Add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0); 
        
        //0->1->2
        System.out.println(ll);

        //Remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}
