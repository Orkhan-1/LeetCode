import java.util.HashMap;
import java.util.Map;

/*
 * -We need to keep head and tail, and add/remove nodes in between
 * -Nodes are Double Liked List and also contains key, to remove value from the map
 * -get () - remove node, and it after head
 * -put () - remove if exist, if not just add after head
 * */

// Time complexity - O (1)
// Space complexity - O (N)
public class LRUCache {

    private Map<Integer, Node> lruCache = new HashMap<>();
    private int capacity;
    private int currentCapacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (lruCache.get(key) == null) {
            return -1;
        }
        Node node = lruCache.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (lruCache.get(key) != null) {
            Node node = lruCache.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            if (currentCapacity == capacity) {
                Node node = tail.prev;
                lruCache.remove(node.key);
                removeNode(node);
                currentCapacity--;
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            lruCache.put(key, newNode);
            currentCapacity++;
        }
    }

    private void addNode(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void removeNode(Node node) {
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
    }


    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
