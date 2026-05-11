public class N2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var result = new ListNode(0);
        var temp = result;
        var carry  = 0;
        while (l1 != null || l2 != null) {
            var cur = carry;
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(cur % 10);
            carry = cur / 10;
            temp = temp.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(1);
        }
        return result.next;
    }
}
