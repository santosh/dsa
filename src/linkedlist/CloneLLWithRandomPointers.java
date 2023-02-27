package linkedlist;

/*
Given a linked list having two pointers in each node. The first one points to the next node of the list, however, the other pointer is random and can point to any node of the list. Write a program that clones the given list in O(1) space, i.e., without any extra space.
*/

// Class name should be "Source",
// otherwise solution won't be accepted
public class CloneLLWithRandomPointers {
    private static void traverse(ListNodeModified head){
        while(head !=null){
            System.out.println(head);
            head= head.getNext();
        }

    }
    static class ListNodeModified {
        private int data ;
        private ListNodeModified next ;
        private ListNodeModified random ;

        public ListNodeModified(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNodeModified getNext() {
            return next;
        }

        public void setNext(ListNodeModified next) {
            this.next = next;
        }

        public ListNodeModified getRandom() {
            return random;
        }

        public void setRandom(ListNodeModified random) {
            this.random = random;
        }

        @Override
        public String toString() {
            return "ListNodeModified{" +
                    "data=" + data +
                    ", random=" + random.getData() +
                    '}';
        }
    }
    public static ListNodeModified clone(ListNodeModified start){
        ListNodeModified curr = start, temp = null;

        while (curr != null) {
            temp = curr.getNext();

            curr.setNext(new ListNodeModified(curr.getData()));
            curr.getNext().setNext(temp);
            curr = temp;
        }
        curr = start;

        while (curr != null) {
            if (curr.getNext() != null)
                curr.getNext().setRandom(curr.getRandom()!=null ? curr.getRandom().getNext(): curr.getRandom());
            curr = curr.getNext().getNext();
        }

        ListNodeModified original = start, copy = start.getNext();

        temp = copy;

        // now separate the original list and copied list
        while (original != null) {
            original.setNext(original.getNext().getNext());
            copy.setNext((copy.getNext()!= null) ? copy.getNext().getNext()
                    : copy.getNext());
            original = original.getNext();
            copy = copy.getNext();
        }
        return temp;
    }
    public static void main(String[] args) {
        ListNodeModified node1  = new ListNodeModified(1);
        ListNodeModified node2  = new ListNodeModified(2);
        ListNodeModified node3  = new ListNodeModified(3);
        ListNodeModified node4  = new ListNodeModified(4);
        ListNodeModified node5  = new ListNodeModified(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node1.setRandom(node3);
        node2.setRandom(node1);
        node3.setRandom(node5);
        node4.setRandom(node5);
        node5.setRandom(node2);

        traverse(node1);

        System.out.println("After cloning");

        traverse(clone(node1));
        //Confirm that the LL is cloned
        System.out.println(node1.hashCode() + "  -  "+ clone(node1).hashCode());
    }
}