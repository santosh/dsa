package linkedlist;

/**
 * We have a ListNode with a random pointer. Random pointer con point
 * to any node in LL.
 *
 * You have to clone the LL with random pointer.
 */
public class CloneWithRandomPointer {
    public static ListNodeWithRandom clone(ListNodeWithRandom head) {
        // iterate over and clone the nodes and keep adjacent to it
        ListNodeWithRandom curr = head, temp = null;

        while (curr != null) {
            temp = curr.getNext();

            curr.setNext(new ListNodeWithRandom(curr.getData()));
            curr.getNext().setNext(temp);

            curr = temp;
        }

        // clone the random pointers
        curr = head;
        while (curr != null) {
            if (curr.getNext() != null) {
                curr.getNext().setRandom(curr.getRandom().getRandom().getNext());
                curr = curr.getNext().getNext();
            }
        }

        // detach the cloned nodes from original
        ListNodeWithRandom original = head, clone = head.getNext();
        ListNodeWithRandom clonedHead = clone;

        while (original != null) {
            original.setNext(original.getNext().getNext());
            clone.setNext(clone.getNext().getNext());

            original = original.getNext();
            clone = clone.getNext();
        }

        return clonedHead;
    }

    public static void main(String[] args) {
        ListNodeWithRandom node1 = new ListNodeWithRandom(1);
        ListNodeWithRandom node2 = new ListNodeWithRandom(2);
        ListNodeWithRandom node3 = new ListNodeWithRandom(3);
        ListNodeWithRandom node4 = new ListNodeWithRandom(4);
        ListNodeWithRandom node5 = new ListNodeWithRandom(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node1.setRandom(node3);
        node2.setRandom(node1);
        node3.setRandom(node5);
        node4.setRandom(node5);
        node5.setRandom(node2);
    }
}
