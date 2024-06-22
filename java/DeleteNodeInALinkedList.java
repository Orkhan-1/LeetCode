// Time complexity - O (1)
// Space complexity - O (1)
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        // 4->5->1->9
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
