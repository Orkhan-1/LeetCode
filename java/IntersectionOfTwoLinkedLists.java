public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode l1Temp = l1;
        int s1 = 0;
        while (l1Temp != null) {
            l1Temp = l1Temp.next;
            s1++;
        }

        ListNode l2Temp = l2;
        int s2 = 0;
        while (l2Temp != null) {
            l2Temp = l2Temp.next;
            s2++;
        }

        if (s1 > s2) {
            int d = s1 - s2;
            while (d != 0) {
                l1 = l1.next;
                d--;
            }
        } else {
            int d = s2 - s1;
            while (d != 0) {
                l2 = l2.next;
                d--;
            }
        }

        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

}
