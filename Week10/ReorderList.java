class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;   
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode mid = slow;
        ListNode cur = slow.next;
        while(cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = mid.next;
            mid.next = next;
        }
        
        ListNode p1 = head;
        ListNode p2 = mid.next;
        
        while(p1 != mid){
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }
        
    }
}
