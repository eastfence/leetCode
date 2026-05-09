public class N206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        var curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        var s = new N206();
        var node =  new  ListNode();
        node.val = 1;
        node.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
        s.reverseList(node);
    }
}
