package tree;

public class BST_Operations {
    static Node pre = new Node();
    static Node suc = new Node();
    public Node root;

    public BST_Operations() {
        root = null;
    }

    public static void main(String[] args) {
        BST_Operations bt = new BST_Operations();

        bt.insert(50);
        bt.insert(30);
        bt.insert(70);
        bt.insert(60);
        bt.insert(10);
        bt.insert(90);

        System.out.println("Binary tree after insertion: ");
        bt.inorderTraversal(bt.root);
        Node deleteNode = null;
        deleteNode = bt.deleteNode(bt.root, 30);
        System.out.println();
        bt.inorderTraversal(bt.root);
        System.out.println("Smallest element in the BST is: " + bt.smallestElement(bt.root));
        System.out.println("Largest element in the BST is: " + bt.largestElement(bt.root));

        bt.findPreSuc(bt.root, 60);
        if (pre != null)
            System.out.println("Predecessor is: " + pre.data);
        else
            System.out.println("There is no predecessor");

        if (suc != null)
            System.out.println("Successor is: " + suc.data);
        else
            System.out.println("There is no successor");
    }

    // Function to find the successor and predecessor nodes
    public void findPreSuc(Node root, int key) {
        if (root == null)
            return;

        if (root.data == key) {
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null)
                    temp = temp.right;
                pre = temp;
            }

            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                suc = temp;
            }
            return;
        }

        if (root.data > key) {
            suc = root;
            findPreSuc(root.left, key);
        } else {
            pre = root;
            findPreSuc(root.right, key);
        }
    }
    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        } else {
            Node current = root, parent = null;
            while (true) {
                parent = current;

                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inorderTraversal(Node node) {
        if (root == null) {
            System.out.println("BST is empty");
            return;
        } else {
            if (node.left != null) inorderTraversal(node.left);
            System.out.println(node.data + " ");
            if (node.right != null) inorderTraversal(node.right);
        }
    }

    public Node minNode(Node root) {
        if (root.left != null) {
            return minNode(root.left);
        } else {
            return root;
        }
    }

    // funtion to return the smallest element
    public int smallestElement(Node temp) {
        if (root == null) {
            System.out.println("The BST is empty!");
            return 0;
        } else {
            int leftMin, rightMin;
            int min = temp.data;

            if (temp.left != null) {
                leftMin = smallestElement(temp.left);
                min = Math.min(min, leftMin);
            }

            if (temp.right != null) {
                rightMin = smallestElement(temp.right);
                min = Math.min(min, rightMin);
            }

            return min;
        }
    }

    // funtion to return the smallest element
    public int largestElement(Node temp) {
        if (root == null) {
            System.out.println("The BST is empty!");
            return 0;
        } else {
            int leftMax, rightMax;
            int max = temp.data;

            if (temp.left != null) {
                leftMax = largestElement(temp.left);
                max = Math.max(max, leftMax);
            }

            if (temp.right != null) {
                rightMax = largestElement(temp.right);
                max = Math.max(max, rightMax);
            }

            return max;
        }
    }

    public Node deleteNode(Node node, int value) {
        if (node == null) {
            return null;
        } else {
            if (value < node.data) node.left = deleteNode(node.left, value);
            else if (value > node.data) node.right = deleteNode(node.right, value);
            else {
                if (node.left == null && node.right == null) node = null;
                else if (node.left == null) {
                    node = node.right;
                } else if (node.right == null) {
                    node = node.left;
                } else {
                    Node temp = minNode(node.right);
                    node.data = temp.data;
                    node.right = deleteNode(node.right, temp.data);
                }
            }
            return node;
        }
    }
}
