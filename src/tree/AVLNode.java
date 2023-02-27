package tree;

public class AVLNode {
    int data, height;
    AVLNode left, right;

    public AVLNode() {

    }

    public AVLNode(int item) {
        data = item;
        height = 1;
        left = right = null;
    }
}