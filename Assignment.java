import java.util.Stack;

public class Assignment {
    
    class Node {
        char data;  
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public boolean isPalindrome() {
        Stack<Character> S = new Stack<>();
        if (head == null) {
            System.out.println("LinkedList is Empty.");
            return false;
        }

        Node temp = head;
        // Push all values into stack
        while (temp != null) {
            S.push(temp.data); 
            temp = temp.next;
        }

        temp = head;
        
        while (temp != null) {
            if (S.peek() != temp.data) {
                return false;
            }
            S.pop();
            temp = temp.next;
        }
        return true;
    }

    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(token);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, "/" + st.pop());
        }

        return result.toString();
    }


    public static void main(String[] args) {
        Assignment list = new Assignment();
        list.head = list.new Node('A');
        list.head.next = list.new Node('B');
        list.head.next.next = list.new Node('C');
        list.head.next.next.next = list.new Node('D');
        list.head.next.next.next.next = list.new Node('A');

        System.out.println("Is palindrome? " + list.isPalindrome()); 

        System.out.println(simplifyPath("/a/.."));
    }
}
