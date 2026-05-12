/*思路
* 每k个节点进行一次链表反转
* 仍然需要虚拟头*/

public class N25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 当前组的前驱
        var prev = dummyHead;

        while (true) {
            // 本组的结尾
            var end = prev;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummyHead.next;
                }
            }

            // 保存本组的头和下一组的头
            var start = prev.next;
            var nextGroup = end.next;

            // 开始反转链表
            ListNode pre = null;
            var curr = start;
            while (curr != nextGroup) {
                var next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }

            //反转后的链表接回
            prev.next = pre;
            start.next = nextGroup;

            prev = start;
        }
    }

    public static void main(String[] args) {
        var s = new N25();
        s.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 2);
    }
}
