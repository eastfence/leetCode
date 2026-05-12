/*解题思路 快指针往前走n步 随后快慢指针一起移动
* 当快指针走到终点的时候 慢指针刚好停在要删除节点的前一个
* 增加虚拟头节点的意义： 第一个节点没有父节点 会导致无法删除*/

public class N19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var dummy = new ListNode(0);
        dummy.next = head;
        var fast = dummy;
        var slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        var s = new N19();
        s.removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
    }
}
