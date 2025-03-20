import java.util.*;

public class StackB {

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i + 1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        str = result.toString();
        return str;
    }

    public static boolean isValid(String str) { //O(n)
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //Opening
            if(ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            }
            else {
                //Closing
                if(s.isEmpty()) {
                    return false;
                }
                if( (s.peek() == '(' && ch == ')')
                  ||(s.peek() == '[' && ch == ']')
                  ||(s.peek() == '{' && ch == '}'))
                {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if(s.isEmpty()) {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean duplicateParentheses(String str1) { //O(n)
        Stack<Character> S = new Stack<>();

        for(int i = 0; i < str1.length(); i++) {

            char ch = str1.charAt(i);
            // closing ')'
            if(ch == ')') {
                int cnt = 0;
                while (S.peek() != '(') {
                    S.pop();
                    cnt++;
                }
                if(cnt < 1) {
                    return true; //Duplicate
                }
                else {
                    S.pop(); //Opening Pair
                }
            }
            else {
                S.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int heights[]) { //O(n)
        int maxArea = 0;
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];

        //Next Smaller right -> O(n)
        Stack<Integer> s = new Stack<>();
        for(int i = heights.length-1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = heights.length;
            } else {
                //Top
                nsr[i] = s.peek();
            }

            s.push(i);
        }
        //Next Smaller left -> O(n)
        s = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                //Top
                nsl[i] = s.peek();
            }

            s.push(i);
        }
        //Current Area -> j-i-1 => nsr[i] - nsl[i] - 1 -> O(n)
        for(int i = 0; i < heights.length; i++) {
            int height = heights[i] ;
            int width = (nsr[i] - nsl[i] - 1);
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("Max Area in histogram = " +maxArea);
    }

    //Recursion
    public static void pushAtBottom(Stack<Integer> s, int data) {
        //Base Case
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        //Base case:
        if(s.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top); 
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
        
    }
    //stack Implementation using LinkedList
    static class InnerStackB_1 {
    
        static Node head = null;
        
         // Check if stack is empty
         public static boolean isEmpty() {
            return head == null;
         }

         // Push an element onto the stack
         public static void push(int data) {
            Node newNode = new Node(data);

            if(isEmpty()) {
               head = newNode;
               return;
            }

            newNode.next = head;
            head = newNode;
         }

         // Pop an element onto the stack
         public static int pop() {
            if(isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
         }

          // Peek at the top element
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Stack is Empty");
            }
            return head.data;
        }

    }

    //Stack Implementation using ArrayList 
    static class InnerStackB {
    
        static ArrayList<Integer> list = new ArrayList<>();

        // Check if stack is empty
        public static boolean isEmpty() {
            return list.isEmpty();
        }

        // Push an element onto the stack
        public static void push(int data) {
            list.add(data);
        }

        // Pop an element from the stack
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // Peek at the top element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        //InnerStackB s = new InnerStackB(); 
        //InnerStackB_1 s = new InnerStackB_1(); 

        //JCF
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        //pushAtBottom(s, 4);
        //reverseStack(s);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // String result = reverseString("Hello");
        // System.out.println("Reversed String: " +result);

        int stocks[] = {100, 80, 60, 70, 80, 85, 100};
        int span[] = new int[stocks.length];
        //stockSpan(stocks, span);

        for(int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }

        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> st = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for(int i = arr.length-1; i >= 0; i--) {
            //S1-> while loop
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) { //Store idx in stack
                st.pop();
            }
            //S2->if-else
            if(st.isEmpty()) {
                nxtGreater[i] = -1;
            }
            else{
                nxtGreater[i] = arr[st.peek()];
            }

            //S3->Push in st
            st.push(i);
        }
        //findNextGreatest Printing
        for(int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i]+ " ");
        }
        System.out.println();

        // String str = "({}[])"; //True
        // System.out.println(isValid(str));
        // String str1 = "((a+b))";
        // String str2 = "(a-b)";
        // System.out.println(duplicateParentheses(str2));

        int heights[] = {2, 1, 5, 6, 2, 3}; //Heights of histogram
        maxArea(heights);
    }
}
