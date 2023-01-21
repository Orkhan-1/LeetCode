public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        // 1. Calculate length of each list
        int lengthL1 = 0;
        ListNode headL1 = l1;
        while (headL1 != null) {
            lengthL1++;
            headL1 = headL1.next;
        }

        int lengthL2 = 0;
        ListNode headL2 = l2;
        while (headL2 != null) {
            lengthL1++;
            headL2 = headL2.next;
        }

        //2.Move longer one n steps
        if (lengthL1 > lengthL2) {
            int diff = lengthL1 - lengthL2;
            while (diff > 0) {
                l1 = l1.next;
                diff--;
            }
        } else {
            int diff = lengthL2 - lengthL1;
            while (diff > 0) {
                l2 = l2.next;
                diff--;
            }
        }

        // 2. Find intersection
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }

}
