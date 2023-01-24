package tree;

public class BinaryTree {
    Node root; // Root of the Binary Tree
    public BinaryTree() {
        root = null;
    }

    // function to print level order traversal of tree
    void printLevelOrder() {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++) {
            printCurrentLevel(root, i);
        }
    }

    int height(Node root) {
        if (root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.max(lheight, rheight)+1;
    }

//    function print nodes at the current level
    void printCurrentLevel(Node root, int level) {
        if (root==null)
            return;
        if (level == 1) System.out.print(root.data + " ");
        else if (level > 1) printCurrentLevel(root.left, level-1);
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("Level Order Traversal of" + "binary tree is");
        tree.printLevelOrder();
    }
}
