package tree;

public class Node {
    int data;
    Node left, right;

    public Node() {

    }

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
