/*环形链表
* 解决思路 使用快慢指针 总会快慢指针一定会相遇或者快指针变成Null*/

public class N141 {
    public boolean hasCycle(ListNode head) {
        var fast = head;
        var slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
