public class N206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


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
        var node =  s.new ListNode();
        node.val = 1;
        node.next = s.new ListNode(2, s.new ListNode(3, s.new ListNode(4, s.new ListNode(5))));
        s.reverseList(node);
    }
}
