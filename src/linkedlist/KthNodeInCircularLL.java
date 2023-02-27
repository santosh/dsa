package linkedlist;

public class KthNodeInCircularLL {
    public static ListNode getNode(ListNode head, int k) {
        int counter = 1;
        ListNode currentNode = head;
        while (counter < k) {
            counter++;
            currentNode = currentNode.getNext();
        }

        return currentNode;
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

        System.out.println(getNode(node1, 5).getData());
        System.out.println(getNode(node1, 6).getData());
        System.out.println(getNode(node1, 7).getData());
    }
}
