import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Time complexity -  O(N * log(k))
// Space complexity - O(k) - determined by the PriorityQueue
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            current.next = min;
            current = current.next;

            if (min.next != null) {
                minHeap.add(min.next);
            }
        }

        return result.next;
    }
}
