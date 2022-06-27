package sort;

import linkedlist.LinkedList;
import linkedlist.ListNode;

/**
 * There are 2 arrays. array1 and array2. array1 already has capacity to
 * accommodate array2.
 *
 * Constraint: No extra space should be used.
 */
public class MergeTwoSortedLL {
    public static ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        if(head1.getData() < head2.getData()) {
            head1.setNext(merge(head1.getNext(), head2));
            return head1;
        }

        else {
            head2.setNext(merge(head1, head2.getNext()));
            return head2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(11);

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(6);
        ListNode node10 = new ListNode(8);
        ListNode node11 = new ListNode(10);


        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);
        node10.setNext(node11);

        LinkedList.traverse(node1);
        System.out.println();
        LinkedList.traverse(node7);

        ListNode newNode = merge(node1, node7);

        System.out.println();
        LinkedList.traverse(newNode);
    }
}
