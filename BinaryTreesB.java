import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreesB {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] != -1) {
                Node newNode = new Node(nodes[idx]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);

                return newNode;
            }
            return null;
        }

        public static void preOrder(Node root) { // O(N)
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");

            if (root.left != null) {
                preOrder(root.left);
            } else {
                System.out.print("-1 "); // Print -1 for missing left child
            }

            if (root.right != null) {
                preOrder(root.right);
            } else {
                System.out.print("-1 "); // Print -1 for missing right child
            }
        }

        public static void inOrder(Node root) { // O(N)
            if (root == null) {
                return;
            }

            if (root.left == null) {
                System.out.print("-1 ");
            } else {
                inOrder(root.left);
            }

            System.out.print(root.data + " ");

            if (root.right == null) {
                System.out.print("-1 ");
            } else {
                inOrder(root.right);
            }
        }

        public static void postOrder(Node root) { // O(N)
            if (root == null) {
                return;
            }

            if (root.left == null) {
                System.out.print("-1 ");
            } else {
                postOrder(root.left);
            }

            if (root.right == null) {
                System.out.print("-1 ");
            } else {
                postOrder(root.right);
            }

            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) { //O(N)
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();

                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");

                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    
        public static void levelOrderLineByLine(Node root) { //O(N)
            if (root == null) return;
        
            Queue<Node> q = new LinkedList<>();
            q.add(root);
        
            while (!q.isEmpty()) {
                int levelSize = q.size();  // Number of nodes at current level
        
                for (int i = 0; i < levelSize; i++) {
                    Node curr = q.remove();
                    System.out.print(curr.data + " ");
        
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
        
                System.out.println();  // Newline after each level
            }
        }
    }

    public static int height(Node root) { // O(N)
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // Height Calculation
        int finHeight = Math.max(leftHeight, rightHeight) + 1;

        return finHeight;
    }

    public static int countNodes(Node root) { // O(N)
        if (root == null) {
            return 0;
        }

        int leftCnt = countNodes(root.left);
        int rightCnt = countNodes(root.right);
        int treeCnt = (leftCnt + rightCnt) + 1;

        return treeCnt;
    }

    public static int Sum(Node root) { // O(N)
        if (root == null) {
            return 0;
        }

        int leftSum = Sum(root.left);
        int rightSum = Sum(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int diameter2(Node root) {
        if (root == null) {
            return 0;
        }
        // Left diameter
        int leftDia = diameter2(root.left);
        // Left Height
        int leftHt = height(root.left);

        // right diameter
        int rightDia = diameter2(root.right);
        // right Height
        int rightHt = height(root.right);

        int selfDiameter = leftHt + rightHt + 1;

        return Math.max(selfDiameter, Math.max(rightDia, leftDia));
    }

    // Optimized Approach
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) { // O(N)
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info righInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam), leftInfo.ht + righInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, righInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        // Left Node
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        // Right Node
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        // boolean leftAns = isSubtree(root.left, subRoot); //lSubTree -> true
        // boolean rightAns = isSubtree(root.right, subRoot);

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static class Information {
        Node node;
        int horDist;

        public Information(Node node, int horDist) {
            this.node = node;
            this.horDist = horDist;
        }
    }

    public static void topView(Node root) {
        // Level Order Traversal
        Queue<Information> q = new LinkedList<>();
        // Key, Value
        HashMap<Integer, Node> hMap = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Information(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Information curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!hMap.containsKey(curr.horDist)) { // First time horDist has occurred
                    hMap.put(curr.horDist, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Information(curr.node.left, curr.horDist - 1));
                    min = Math.min(curr.horDist - 1, min);
                }

                if (curr.node.right != null) {
                    q.add(new Information(curr.node.right, curr.horDist + 1));
                    max = Math.max(curr.horDist + 1, max);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(hMap.get(i).data + " ");
        }
        System.out.println();
    }

    public static void kLevel(Node root, int level, int k) {
        // Base case
        if (root == null)
            return;

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kLevel(root.left, level + 1, k);
        kLevel(root.right, level + 1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null)
            return false;

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Last Common Ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        // Last equal node => i-1th index
        Node lca = path1.get(i - 1);
        return lca;
    }

    // Optimized -> O(N)
    public static Node lca2(Node root, int n1, int n2) {
        // Base Case:
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        // leftLca = validVal, rightLca = null
        if (rightLCA == null) {
            return leftLCA;
        }

        if (leftLCA == null) {
            return rightLCA;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int kthAncestor(Node root, int n, int k) {
        if (root == null)
            return -1;

        if (root.data == n)
            return 0;

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int maxDistance = Math.max(leftDist, rightDist);
        if (maxDistance + 1 == k) {
            System.out.println(root.data);
        }
        return maxDistance + 1;
    }

    public static int sumTree(Node root) { // O(N)
        if (root == null)
            return 0;

        int leftChild = sumTree(root.left);
        int rightChild = sumTree(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;

        return data;
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Practice Questions
    //public static boolean isUnivalued(Node root, int val) {
    //     if (root == null) {
    //         return true;
    //     }

    //     if (root.left != null && root.left.data != root.data) {
    //         return false;
    //     }

    //     if (root.right != null && root.right.data != root.data) {
    //         return false;
    //     }
    // }

    public static boolean isUnivalued(Node root, int val) {
        if (root == null) {
            return true;
        }

        if (root.data != val) {
            return false;
        }

        // Recursively check left and right subtree
        return isUnivalued(root.left, val) && isUnivalued(root.right, val);
    }

    static class Node{
        int data;
        Node left, right;

        public Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static Node mirror(Node root) {
        if(root == null) return null;

        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

          // Swap left and right
          root.left = rightMirror;
          root.right = leftMirror;
  
          return root;
    }

    public static void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static Node deleteLeafNodes(Node root, int x) {
        if(root == null) return null;

        root.left = deleteLeafNodes(root.left, x);
        root.right = deleteLeafNodes(root.right, x);

        if(root.left == null && root.right == null && root.data == x) {
            return null; // delete the node
        }

        return root;
    }

    public static void main(String args[]) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // int k = 3;
        // int n1 = 4, n2 = 5;

        // Subtree
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(height(root));
        // System.out.println(countNodes(root));
        // System.out.println(Sum(root));
        // System.out.println(diameter2(root));
        // System.out.println(diameter(root).diam);
        // System.out.println(isSubtree(root, subRoot));
        // topView(root);
        // kLevel(root, 1, k);
        // System.out.println(lca(root, n1, n2).data);
        // System.out.println(lca2(root, n1, n2).data);
        // System.out.println(minDist(root, n1, n2));
        // int n = 4, k = 1;
        // kthAncestor(root, n, k);
        // sumTree(root);
        // preOrder(root);

        // if (isUnivalued(root, root.data)) {
        //     System.out.println("Yes");
        // } else {
        //     System.out.println("No");
        // }
        
        // System.out.println("Original In-order:");
        // inorder(root);

        // mirror(root); // Mirror the tree

        // System.out.println("\n Mirrored In-order:");
        // inorder(root);
    }
}
