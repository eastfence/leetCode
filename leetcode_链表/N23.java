/*思路
 * 递归 两两合并*/

public class N23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        var mid = (l + r) / 2;
        var left = merge(lists, l, mid);
        var right = merge(lists, mid + 1, r);
        return mergeTwo(left, right);
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        var dummy = new ListNode(0);
        var cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
