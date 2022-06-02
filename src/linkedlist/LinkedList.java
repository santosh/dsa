package linkedlist;

public class LinkedList {
    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.println(head.getData());
            head = head.getNext();
        }
    }

    public static int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.getNext();
        }
        return count;
    }

    public static void traverseRecursive(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.println(head.getData());

        traverseRecursive(head.getNext());
    }

    public static ListNode insertAtK(ListNode head, int data, int k) {
        if (head == null && k != 0) {
            return head;
        }
        if (k < 0 || k > length(head)) {
            return head;
        }

        ListNode newNode = new ListNode(data);

        if (k == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            int count = 0;
            ListNode temp = head;

            while (count < k-1) {
                temp = temp.getNext();
                count++;
            }

            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        return head;

    }

        public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

//      traverse(node1);
//      System.out.println(length(node1));
        insertAtK(node1, 19, 5);
//      traverseRecursive(node1);
        System.out.println(isPresent(node1, 9));
    }
}
