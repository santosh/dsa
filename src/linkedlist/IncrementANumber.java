package linkedlist;

/**
 * There is a linked list representing a number. i.e. 1 -> 2 -> 3 represents
 * the number 123.
 *
 * You have to write an algorithm to increment a number by 1.
 *
 * Test case:
 * 1. 129
 * 2. 999
 * 3. 199
 * 4. 546
 */
public class IncrementANumber {
    public static ListNode addOne(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }

        head = LinkedList.reverse(head);
        head = addOneUtil(head);
        head = LinkedList.reverse(head);

        return head;
    }

    private static ListNode addOneUtil(ListNode head) {
        ListNode res = head;
        ListNode temp = null;
        int carry = 1;  // Why? Because we have to add 1 to the head
        int sum;

        while (head != null) {
            sum = head.getData() + carry;
            carry = sum >= 10 ? 1: 0;
            sum = sum % 10;
            head.setData(sum);
            temp = head;
            head = head.getNext();
        }

        // if carry is > 9; add new node to have 1.
        if (carry > 0) {
            temp.setNext(new ListNode(carry));
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);

        node1.setNext(node2);
        node2.setNext(node3);

        ListNode newHead = addOne(node1);

        LinkedList.traverse(newHead);
    }
}
