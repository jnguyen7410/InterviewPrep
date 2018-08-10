import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;

public class AVLTree {
    static class Node {
        public final static int SIZE_OF_CHILDREN = 3;
        int value;
        public Node left;
        public Node right;
        public Node[] children;
        public boolean visited;
        public int size;
        public int height;

        public Node (int value) {
            this.value = value;
            left = null;
            right = null;
            //children = new ArrayList<Node>();
            //children = new Node[SIZE_OF_CHILDREN];
        }
    }

    // FIELDS
    public Node root;

    public AVLTree() {
        root = null;
    }

    public AVLTree(int value) {
        this.root = new Node(value);
    }
    
    public AVLTree(Node root) {
        this.root = root;
    }

    public Node add(int num) {
        return add(this.root, num);
    }

    public Node add(Node root, int num) {
        if (root == null) {
            root = new Node(num);
        } else if (root.value == num) {
            return null; //you don't want to insert a duplicate
        } 
        else if (root.value > num) {
            root.left = add(root.left, num);
        } else if (root.value < num) {
            root.right = add(root.right, num);
        }
        int balanceFactor = balanceFactor(root.left, root.right);
        if (balanceFactor > 1) {
            //left heavy
            if (height(root.left.left) >= height(root.left.right)) {
                root = rotateRight(root);
            } else {
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
            }
        } else if (balanceFactor < -1) {
            //right heavy
            if (height(root.right.right) >= height(root.right.left)) {
                root = rotateLeft(root);
            } else {
                root.left = rotateRight(root.right);
                root = rotateLeft(root);
            }
        } else {
            root.height = setHeight(root);
            root.size = setSize(root);
        }

        return root;
    }

    public Node rotateRight(Node root) {
        Node newRoot = root.left;
        root.left = root.left.right;
        newRoot.left = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }

    public Node rotateLeft(Node root) {
        Node newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }

    private int height(Node root) {
        return root == null ? 0 : root.height;
    }

    private int size(Node root) {
        return root == null ? 0 : root.size;
    }

    private int setHeight(Node root) {
        return root == null ? 0
                : 1 + Math.max((root.left != null ? root.left.height : 0),
                        (root.right != null ? root.right.height : 0));
    }

    private int setSize(Node root) {
        return root == null ? 0
                : 1 + Math.max((root.left != null ? root.left.size : 0),
                        (root.right != null ? root.right.size : 0));
    }

    private int balanceFactor(Node left, Node right) {
        return height(left) - height(right);
    }


    /* SEARCH FUNCTIONS */
    public Node search(int value) {
        return search(value, this.root);
    }

    public Node search(int value, Node root) {
        if (root == null) {
            return null;
        } else if (root.value > value) {
            return search(value, root.left);
        } else if (root.value < value) {
            return search(value, root.right);
        }
		return root;
    }

    public void visit(Node root) {
        //fill this with visiting logic
    }

    public static Node dfsRecursive( Node root, int value) {
        if (root == null) {
            return null;
        } else if (root.value == value) {
            return root;
        }
        // visit(root); // Use this to do custom logic when visiting node
        root.visited = true;
        Node leftResult = dfsRecursive(root.left, value);
        if (leftResult != null) {
            return leftResult;
        }
        Node rightResult = dfsRecursive(root.right, value);
        if (rightResult != null) {
            return rightResult;
        }
        /*
        for (Node n : root.children) {
            Node result = dfsRecursive(n, value);
            if (result != null) {
                return result;
            }
        }
        */

        return null;
    }

    public static String printNode(Node root) {
        return root == null ? "No node found!" : Integer.toString(root.value);
    }

    public Node dfsIterative( Node root, int value) {

        return null;
    }

    public Node bfs(Node root, int value) {
        return null;
    }

    /* PRINT AND TRAVERSE */
    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public static void printPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printPostOrder(Node root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String[] args) {
        System.out.println("AVL Tree Stuff: ");
        System.out.println("-----------------------------------");
        System.out.println("");
        AVLTree tree = new AVLTree(1);
        tree.root = tree.add(2);
        tree.root = tree.add(3);
        tree.root = tree.add(4);
        tree.root = tree.add(5);
        tree.root = tree.add(6);
        tree.root = tree.add(7);
        tree.root = tree.add(8);
        tree.root = tree.add(9);
        tree.root = tree.add(10);
        System.out.println("size = " + tree.root.size);
        System.out.println("height = " + tree.root.height);
        printInOrder(tree.root);
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.println("DFS Test: ");        
        System.out.println("-----------------------------------");
        System.out.println("");
        Node test1 = dfsRecursive(tree.root, 10);
        System.out.println("Test 1 [Find 10]: " + printNode(test1));
        Node test2 = dfsRecursive(tree.root, 11);
        System.out.println("Test 2 [Find 11]: " + printNode(test2));
        Node test3 = dfsRecursive(tree.root, 1);
        System.out.println("Test 3 [Find 1]: " + printNode(test3));
        Node test4 = dfsRecursive(tree.root, 8);
        System.out.println("Test 4 [Find 8]: " + printNode(test4));
        Node test5 = dfsRecursive(tree.root, 200);
        System.out.println("Test 5 [Find 200]: " + printNode(test5));

    }
}