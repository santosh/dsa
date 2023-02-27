package tree;

public class AVLTree {
    AVLNode root;
    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // let us define left rotate function
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right));
        y.height = max(height(y.left), height(y.right));

        return y;
    }

    // let us define right rotate function
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        x.left = T2;

        y.height = max(height(y.left), height(y.right));
        x.height = max(height(x.left), height(x.right));

        return x;
    }

    // insert elements in an AVLTree
    AVLNode insert(AVLNode node, int key) {
        if (node == null)
            return (new AVLNode(key));

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);


        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.data) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    void preOrder(AVLNode node) {
        if (node != null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(AVLNode node) {
        if (node != null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

//        tree.preOrder(tree.root);
        tree.inOrder(tree.root);
    }
}
