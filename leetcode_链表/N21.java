public class N21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-100);
        var cur = result;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return result.next;
    }

    public static void main(String[] args) {
        var s = new N21();
        s.mergeTwoLists(new ListNode(-9, new ListNode(3)), new ListNode(5, new ListNode(7)));
    }
}
