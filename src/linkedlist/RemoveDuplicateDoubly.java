package linkedlist;

public class RemoveDuplicateDoubly {
    public static DLLNode removeDuplicates(DLLNode head) {

        DLLNode current = head;

        while (current.getNext() != null)
        {
            if (current.getData() == current.getNext().getData())
                deleteDLLNode(head, current.getNext());

            else
                current = current.getNext();
        }
        return head;
    }

    public static void deleteDLLNode(DLLNode head, DLLNode del){
        if(head==null || del==null) {
            return ;
        }
        if(head==del) {
            head=del.getNext();
        }
        if(del.getNext()!=null) {
            del.getNext().setPrev(del.getPrev());
        }
        if (del.getPrev() != null)
            del.getPrev().setNext(del.getNext());

    }
    public static void main(String[] args) {
        DLLNode node1 = new DLLNode(1);
        DLLNode node2 = new DLLNode(1);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(4);
        DLLNode node5 = new DLLNode(4);

        node1.setNext(node2);
        node2.setNext(node3); node2.setPrev(node1);
        node3.setNext(node4); node3.setPrev(node2);
        node4.setNext(node5); node4.setPrev(node3);
        node5.setPrev(node4);


//        LinkedList.traverse(node1);
        removeDuplicates(node1);
        DoublyLinkedList.traverse(node1);
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
