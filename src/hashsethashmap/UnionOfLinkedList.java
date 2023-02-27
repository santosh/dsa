package hashsethashmap;

import linkedlist.ListNode;
import java.util.HashMap;
import java.util.Map;

public class UnionOfLinkedList {
    public static ListNode getUnion(ListNode head1, ListNode head2) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode n1 = head1;
        ListNode n2 = head2;

        //Setting the values inside the map
        while (n1 != null) {
            if (map.containsKey(n1.getData())) {
                int val = map.get(n1.getData());
                map.put(n1.getData(), val + 1);
            } else {
                map.put(n1.getData(), 1);
            }
            n1 = n1.getNext();
        }

        while (n2 != null) {
            if (map.containsKey(n2.getData())) {
                int val = map.get(n2.getData());
                map.put(n2.getData(), val + 1);
            } else {
                map.put(n2.getData(), 1);
            }
            n2 = n2.getNext();
        }
        ListNode resultHead = null;
        ListNode current = resultHead;
        for (int data : map.keySet()) {
            if (resultHead == null) {
                resultHead = new ListNode(data);
                current = resultHead;
            } else {
                current.setNext(new ListNode(data));
                current = current.getNext();
            }

        }
        return resultHead;
    }


}
