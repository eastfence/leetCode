/*归并排序 合并链表*/
public class N148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 快慢指针找中点
        var fast = head;
        var slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        var mid = slow.next;
        // 断链
        slow.next = null;

        // 递归拆分排序
        var left = sortList(head);
        var right = sortList(mid);
        // 合并
        return merge(left, right);
    }

    ListNode merge(ListNode l1, ListNode l2) {
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
