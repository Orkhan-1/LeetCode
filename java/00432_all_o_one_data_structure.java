/*
🎯 Problem:
Design a data structure supporting O(1) operations:
- inc(key), dec(key), getMaxKey(), getMinKey()

💡 :
- 🏷️ = key
- 🪣 = bucket count
- head/tail = dummy boundaries

Example Scenario:

Step 1: inc("a")
head <-> [🪣1: 🏷️a] <-> tail

Step 2: inc("b")
head <-> [🪣1: 🏷️a 🏷️b] <-> tail

Step 3: inc("a")
Move "a" to next bucket (count 2)
head <-> [🪣1: 🏷️b] <-> [🪣2: 🏷️a] <-> tail

Step 4: inc("b")
Move "b" to count 2
head <-> [🪣2: 🏷️a 🏷️b] <-> tail

Step 5: dec("a")
Move "a" to count 1
head <-> [🪣1: 🏷️a] <-> [🪣2: 🏷️b] <-> tail

getMaxKey() → 🏷️b
getMinKey() → 🏷️a

🌟 Approach:
- Doubly Linked List of Buckets (each bucket has same count keys)
- HashMap<String, Bucket> keyMap → quickly find key's bucket
- Buckets ordered from min → max count
- All operations O(1)
*/

import java.util.*;

class AllOne {

    class Bucket {
        int count;
        Set<String> keys;
        Bucket prev;
        Bucket next;

        Bucket(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }

    private Map<String, Bucket> keyMap;
    private Bucket head;
    private Bucket tail;

    public AllOne() {
        keyMap = new HashMap<>();
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (!keyMap.containsKey(key)) {
            Bucket b = head.next;
            if (b == tail || b.count != 1) {
                Bucket newBucket = new Bucket(1);
                addBucketAfter(newBucket, head);
                b = newBucket;
            }
            b.keys.add(key);
            keyMap.put(key, b);
        } else {
            Bucket cur = keyMap.get(key);
            Bucket next = cur.next;
            if (next == tail || next.count != cur.count + 1) {
                Bucket newBucket = new Bucket(cur.count + 1);
                addBucketAfter(newBucket, cur);
                next = newBucket;
            }
            next.keys.add(key);
            keyMap.put(key, next);
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                removeBucket(cur);
            }
        }
    }

    public void dec(String key) {
        if (!keyMap.containsKey(key)) {
            return;
        }
        Bucket cur = keyMap.get(key);
        if (cur.count == 1) {
            keyMap.remove(key);
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                removeBucket(cur);
            }
        } else {
            Bucket prev = cur.prev;
            if (prev == head || prev.count != cur.count - 1) {
                Bucket newBucket = new Bucket(cur.count - 1);
                addBucketAfter(newBucket, cur.prev);
                prev = newBucket;
            }
            prev.keys.add(key);
            keyMap.put(key, prev);
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                removeBucket(cur);
            }
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    private void addBucketAfter(Bucket newBucket, Bucket prevBucket) {
        newBucket.prev = prevBucket;
        newBucket.next = prevBucket.next;
        prevBucket.next.prev = newBucket;
        prevBucket.next = newBucket;
    }

    private void removeBucket(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }
}