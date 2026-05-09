/*回文链表
 * 思路 使用快慢指针找到链表中点
 * 把后半段链表反转
 * 将前半段与后半段进行比较*/

public class N234 {
    public boolean isPalindrome(ListNode head) {

        var fast = head;
        var low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        // 找到了中点 low开始往后都是
        ListNode next;
        var curr = low;
        ListNode prev = null;
        // 开始反转链表
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 比较大小
        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
