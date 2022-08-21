package linkedlist;

public class RemoveDuplicate {
    public static ListNode removeDuplicate(ListNode head) {
        ListNode current = head;

        while (current != null) {
            ListNode temp = current;

            while (temp != null && temp.getData() == current.getData()) {
                temp = temp.getNext();
            }

            current.setNext(temp);
            current = current.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

//        LinkedList.traverse(node1);
        removeDuplicate(node1);
        LinkedList.traverse(node1);
    }

//    public static void main(String[] args) {
//        DLLNode node1 = new DLLNode(1);
//        DLLNode node2 = new DLLNode(2);
//        DLLNode node3 = new DLLNode(3);
//        DLLNode node4 = new DLLNode(4);
//        DLLNode node5 = new DLLNode(5);
//
//        node1.setNext(node2);
//        node2.setNext(node3); node2.setPrev(node1);
//        node3.setNext(node4); node3.setPrev(node2);
//        node4.setNext(node5); node4.setPrev(node3);
//        node5.setPrev(node4);
//
//        DoublyLinkedList.traverse(node1);
//    }
}
