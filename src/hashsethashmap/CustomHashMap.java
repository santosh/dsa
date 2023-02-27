package hashsethashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomHashMap {
    static class Node<K, V> {
        private K key;
        private V value;
        private final int hashCode;

        private Node<K, V> next;

        public Node(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHashCode() {
            return hashCode;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    static class HashMap<K, V> {

        private List<Node<K, V>> buckets;

        private int bucketsCount;

        private int size;

        public HashMap() {
            buckets = new ArrayList<>();
            bucketsCount = 10;
            size = 0;

            for (int i = 0; i < bucketsCount; i++)
                buckets.add(null);
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        private final int hashCode(K key) {
            return Objects.hashCode(key);
        }

        private int getBucketIndex(K key) {
            int hashCode = hashCode(key);
            int index = hashCode % bucketsCount;
            index = index < 0 ? index * -1 : index;
            return index;
        }

        public V delete(K key) {
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);
            Node<K, V> head = buckets.get(bucketIndex);
            Node<K, V> prev = null;
            while (head != null) {
                if (head.getKey().equals(key) && hashCode == head.getHashCode())
                    break;

                prev = head;
                head = head.getNext();
            }

            if (head == null)
                return null;

            size--;

            // Remove key
            if (prev != null)
                prev.setNext(head.getNext());
            else
                buckets.set(bucketIndex, head.getNext());

            return head.getValue();
        }

        public V get(K key) {
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);

            Node<K, V> head = buckets.get(bucketIndex);

            while (head != null) {
                if (head.getKey().equals(key) && head.getHashCode() == hashCode)
                    return head.value;
                head = head.next;
            }

            return null;
        }

        public void add(K key, V value) {
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);
            Node<K, V> head = buckets.get(bucketIndex);

            while (head != null) {
                if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
                    head.setValue(value);
                    return;
                }
                head = head.getNext();
            }

            size++;
            head = buckets.get(bucketIndex);
            Node<K, V> newNode
                    = new Node<K, V>(key, value, hashCode);
            newNode.setNext(head);
            buckets.set(bucketIndex, newNode);

            if ((1.0 * size) / bucketsCount >= 0.7) {
                List<Node<K, V>> temp = buckets;
                buckets = new ArrayList<>();
                bucketsCount = 2 * bucketsCount;
                size = 0;
                for (int i = 0; i < bucketsCount; i++)
                    buckets.add(null);

                for (Node<K, V> headNode : temp) {
                    while (headNode != null) {
                        add(headNode.getKey(), headNode.getValue());
                        headNode = headNode.getNext();
                    }
                }
            }
        }

    }
}
