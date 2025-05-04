import java.util.*;

public class BST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root, int key) {// O(H)
        if (root == null)
            return false;

        // Root is equal to key
        if (root.data == key)
            return true;

        // Go to Left subtree
        if (root.data > key) {
            return search(root.left, key);
        } else {
            // Go to right subtree
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if (root == null)
            return null;

        // Left Subtree
        if (root.data > val) {
            root.left = delete(root.left, val);
        }
        // Right Subtree
        else if (root.data < val) {
            root.right = delete(root.right, val);
        } else { // Found the node to delete
                 // Case-1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case-2: Only one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case-3: Two children
            else {
                Node IS = findInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }

    // Inorder Successor
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null)
            return;

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null)
            return true;

        if (min != null && root.data <= min.data) {
            return false;
        }

        if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node createMirror(Node root) { // O(N)
        if (root == null) {
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // T.C => O(n)
    public static Node createBalancedBST(int arr[], int start, int end) {
        // Base Case
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, start, mid - 1);
        root.right = createBalancedBST(arr, mid + 1, end);

        return root;
    }

    // Two Helper Functions
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null)
            return;

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int low, int high) {
        if (low > high)
            return null;

        // Calculate Mid
        int mid = low + (high - low) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, low, mid - 1);
        root.right = createBST(inorder, mid + 1, high);

        return root;
    }

    // T.C => O(2N) ignoring const boiled down to O(N)
    public static Node BST2balancedBST(Node root) {
        // Inorder Sequence -> O(N)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // Sorted Array -> Balanced BST -> O(N)
        return root = createBST(inorder, 0, inorder.size() - 1);
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        // Base Case
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static Node createBST2(ArrayList<Integer> arr, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST2(arr, low, mid - 1);
        root.right = createBST2(arr, mid + 1, high);

        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2) { // T.C->O(N+M)
        // Step-1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1); // Written up

        // Step-2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2); // Written up

        // Merge
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else { // (arr2.get(j) <= arr1.get(i))
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        // If any one array gets exhausted
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // BST Construction -> sorted AL
        return createBST2(finalArr, 0, finalArr.size() - 1);
    }

    // Assignment
    public static int rangeSumBST(Node root, int L, int R) {
        if (root == null)
            return 0;

        int sum = 0;

        // If root's data is greater than L, check the left subtree
        if (root.data > L)
            sum += rangeSumBST(root.left, L, R);

        // If root's data is in the range, include it
        if (root.data >= L && root.data <= R)
            sum += root.data;

        // If root's data is less than R, check the right subtree
        if (root.data < R)
            sum += rangeSumBST(root.right, L, R);

        return sum;
    }

    public static void main(String[] args) {
        // int values[] = { 5, 1, 3, 4, 2, 7 };
        // int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        // Node root = null;

        // for (int i = 0; i < values.length; i++) {
        // root = insert(root, values[i]);
        // }

        // inorder(root);
        // System.out.println();

        // if(search(root, 6)) {
        // System.out.println("Found");
        // }
        // else{
        // System.out.println("Not Found");
        // }

        // root = delete(root, 10);
        // System.out.println();

        // inorder(root);

        // printInRange(root, 5, 12);

        // printRoot2Leaf(root, new ArrayList<>());

        // if(isValidBST(root, null, null)) {
        // System.out.println("Valid");
        // }
        // else{
        // System.out.println("Invalid");
        // }

        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // int arr[] = {3, 5, 6, 8, 10, 11, 12};
        // root = createMirror(root);
        // Node root = createBalancedBST(arr, 0, arr.length-1);
        // root = BST2balancedBST(root);
        // preorder(root);

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Info info = largestBST(root);
        // System.out.println("Largest BST size = " +maxBST);

        Node root = mergeBSTs(root1, root2);
        preorder(root);
    }
}
