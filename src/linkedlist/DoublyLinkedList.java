package linkedlist;

public class DoublyLinkedList {
    public static void traverse(DLLNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.getData() + " <-> ");

        traverse(head.getNext());
    }

    public static void traverseFromTail(DLLNode tail) {
        if (tail == null) {
            return;
        }

        System.out.print(tail.getData() + " <-> ");

        traverseFromTail(tail.getPrev());
    }

    public static int length(DLLNode head) {
        return head == null ? 0 : 1 + length(head.getNext());
    }

    public static DLLNode insertAtK(DLLNode head, int data, int k) {
        if (head == null && k != 0) {
            return head;
        }
        if (k < 0 || k > length(head)) {
            return head;
        }

        DLLNode newNode = new DLLNode(data);

        if (k == 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else {
            int index = 0;
            DLLNode temp = head;

            while (index < k-1) {
                temp = temp.getNext();
                index++;
            }

            newNode.setNext(temp.getNext());
            newNode.getNext().setPrev(newNode);

            newNode.setPrev(temp);
            temp.setNext(newNode);
        }
        return head;

    }

    public static DLLNode reverse(DLLNode head) {
        if (head==null || head.getNext()==null) {
            return head;
        }

        DLLNode tail = getTail(head);
        DLLNode temp = head;

        int left = 0;
        int right = length(head)-1;
        while (left < right) {
            int t = temp.getData();
            temp.setData(tail.getData());
            tail.setData(t);
            temp = temp.getNext();
            tail = tail.getPrev();
            left++;
            right--;
        }
        return head;
    }

    private static DLLNode getTail(DLLNode head) {
        while (head.getNext()!=null) {
            head = head.getNext();
        }

        return head;
    }

    public static void main(String[] args) {
        DLLNode node1 = new DLLNode(1);
        DLLNode node2 = new DLLNode(2);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(4);
        DLLNode node5 = new DLLNode(5);

        node1.setNext(node2);
        node2.setNext(node3); node2.setPrev(node1);
        node3.setNext(node4); node3.setPrev(node2);
        node4.setNext(node5); node4.setPrev(node3);
        node5.setPrev(node4);

        traverse(node1);
//        System.out.println(length(node1));
//        insertAtK(node1, 10, 3);
//        traverse(node1);
//        System.out.println();
//        traverseFromTail(node5);
        reverse(node1);
        System.out.println();
        traverse(node1);
    }
}
