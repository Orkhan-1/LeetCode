class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newL = dummy;
        while(newL.next != null && newL.next.next != null){
            ListNode first = newL.next;
            ListNode second = newL.next.next;
            newL.next = second;
            first.next = second.next;
            second.next = first;
            newL = first;
        }
        return dummy.next;
    }
}