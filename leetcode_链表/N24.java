/*解题思路
* 使用虚拟头节点
* 使用快慢指针 快指针先走1步 随后快慢指针都每次走两步*/

public class N24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        var prev = dummyHead;
        while (prev.next != null && prev.next.next != null) {
            var slow = prev.next;
            var fast = prev.next.next;

            // 交换
            exchange(prev, fast, slow);

            // 移动
            prev = slow;
        }
        return dummyHead.next;
    }

    public void exchange(ListNode temp, ListNode fast, ListNode slow) {
        slow.next = fast.next;
        fast.next = slow;
        temp.next = fast;
    }

    public static void main(String[] args) {
        var res = new N24().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }
}
