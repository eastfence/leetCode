/*环形链表找入口
设链表头到入口的距离为a 相交点为b  相交点距离入口距离为c
慢指针走了 a+b 快指针走了 a+b+k(b+c)
快指针是慢指针的2倍所以 2(a+b) = a+b+k(b+c)
a = (k-1)*(b + c) + c
因为b+c是一个圈 简化可得a=c*/

public class N142 {
    public ListNode detectCycle(ListNode head) {
        var fast = head;
        var slow = head;
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                meet = fast;
                break;
            }
        }
        if (meet != null) {
            var temp = head;
            var fast_n1 = meet;
            while (temp != fast_n1) {
                temp = temp.next;
                fast_n1 = fast_n1.next;
            }
            return fast_n1;
        }
        return null;
    }
}
