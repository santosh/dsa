package linkedlist;

public class Merge2LinkedList {

    /**
     * Merge two linked list on alternate basis.
     * @param head1 Head of first linked list
     * @param head2 Head of second linked list
     * @return ListNode Head of merged linked list
     */
    public static ListNode mergeAlternate(ListNode head1, ListNode head2) {
        ListNode current = head1;

        while (current!=null && head2 != null) {
            ListNode sNext = head2.getNext();
            head2.setNext(current.getNext());
            current.setNext(head2);

            head2 = sNext;
            current = current.getNext().getNext();
        }
        return head1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        ListNode node13 = new ListNode(13);
        ListNode node14 = new ListNode(14);
//        ListNode node15 = new ListNode(15);
//        ListNode node16 = new ListNode(16);
//        ListNode node17 = new ListNode(17);

        node11.setNext(node12);
        node12.setNext(node13);
        node13.setNext(node14);
//        node14.setNext(node15);
//        node15.setNext(node16);
//        node16.setNext(node17);

        ListNode newNode = mergeAlternate(node1, node11);
        LinkedList.traverse(newNode);
    }
}
