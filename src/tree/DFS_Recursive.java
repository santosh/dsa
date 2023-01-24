package tree;

public class DFS_Recursive {
    Node root;


    DFS_Recursive() {
        root = null;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPreorder() {
        printPreorder(root);
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    void printPostorder() {
        printPostorder(root);
    }

    public static void main(String[] args) {
        DFS_Recursive tree = new DFS_Recursive();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(9);
        tree.root.right.right = new Node(10);

        System.out.println("Inorder Traversal of the BT is: ");
//        tree.printInorder();
//        tree.printPreorder();
        tree.printPostorder();
    }
}
