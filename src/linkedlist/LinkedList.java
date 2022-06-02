package linkedlist;

public class LinkedList {
    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.getData() + " -> ");
            head = head.getNext();
        }
    }

    public static void traverseRecursive(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.getData() + " -> ");

        traverseRecursive(head.getNext());
    }

    public static int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.getNext();
        }
        return count;
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

    public static ListNode deleteAtK(ListNode head, int k) {
        if (head == null || k < 0 || k > length(head)) {
            return head;
        }

        if (k == 0) {
            head = head.getNext();
        } else {
            int index = 0;
            ListNode temp = head;

            while (index < k-1) {
                temp = temp.getNext();
                index++;
            }

            ListNode next = temp.getNext().getNext();
            temp.getNext().setNext(null);
            temp.setNext(next);
        }
        return head;
    }

    public static boolean isPresent(ListNode head, int data) {
        while (head != null) {
            if (head.getData() == data) {
                return true;
            }
            head = head.getNext();
        }
        return false;
    }

    public static boolean isPresentRecursive(ListNode head, int data) {
        if (head == null) {
            return false;
        }

        return head.getData() == data || isPresentRecursive(head.getNext(), data);
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    public static boolean hasLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast.equals(slow)) {
                return true;
            }
        }

        return false;
    }

    public static ListNode startOfTheLoop(ListNode head) {
        if (head==null || head.getNext()==null) {
            return null;
        }

        // confirm if it has loop
        ListNode fast = head;
        ListNode slow = head;
        boolean hasLoop = false;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast==slow) {
                hasLoop = true;
                break;
            }
        }

        if (!hasLoop) {
            return null;
        }

        // find the start of the loop
        slow = head;

        while (slow.getData() != fast.getData()) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
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
//        node7.setNext(node3);

        traverse(node1);
//        System.out.println(length(node1));
//        insertAtK(node1, 19, 5);
//        traverseRecursive(node1);
//        System.out.println(isPresentRecursive(node1, 5));
//        System.out.println(findMiddle(node5).getData());
//        System.out.println(startOfTheLoop(node1));
          deleteAtK(node1, 3);
          System.out.println();
          traverse(node1);
    }
}
