package linkedlist;

public class CircularLinkedList {

    /**
     * Traversal implementation for circular linked list.
     *
     * @param head
     * @throws InterruptedException
     */
    public static void traverse(ListNode head) {
        System.out.print(head.getData());

        ListNode nextNode = head.getNext();
        while (nextNode != head) {
            System.out.print(" -> " + nextNode.getData());
            nextNode = nextNode.getNext();
        }
    }

    public static ListNode insertAtK(ListNode head, int data, int k) {
        if (head == null && k != 0) {
            return head;
        }

        if (k < 0 || k > length(head)) {
            return head;
        }

        ListNode newNode = new ListNode(data);
        if (k==0) {
            // insert the new node at head
            ListNode tail = getTail(head);
            tail.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
        } else {
            // jump to the 1 less than the target index
            int counter = 0;
            ListNode temp = head;
            while (counter < k-1) {
                temp = temp.getNext();
                counter++;
            }

            // temp is now a node before the target node
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }

        return head;
    }

    /**
     * TODO: Remove this message after implementation.
     * @param head
     * @param data
     * @param k
     * @return
     */
    public static ListNode deleteAtK(ListNode head, int data, int k) {
        if (head == null && k != 0) {
            return head;
        }

        if (k < 0 || k > length(head)) {
            return head;
        }

        ListNode newNode = new ListNode(data);
        if (k==0) {
            // insert the new node at head
            ListNode tail = getTail(head);
            tail.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
        } else {
            // jump to the 1 less than the target index
            int counter = 0;
            ListNode temp = head;
            while (counter < k-1) {
                temp = temp.getNext();
                counter++;
            }

            // temp is now a node before the target node
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }

        return head;
    }

    private static ListNode getTail(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode nextNode = head.getNext();

        while (nextNode.getNext() != head) {
            nextNode = nextNode.getNext();
        }

        return nextNode;
    }

    private static int length(ListNode head) {
        if (head == null) {
            return 0;
        }

        int counter = 1;
        ListNode nextNode = head.getNext();

        while (nextNode != head) {
            counter++;
            nextNode = nextNode.getNext();
        }
        return counter;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node1);

        traverse(node1);
//        System.out.println(length(node1));
        insertAtK(node1, 10, 2);
//        System.out.println(getTail(node1));
        System.out.println();
        traverse(node1);
    }
}
