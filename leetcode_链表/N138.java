/*随机链表的复制
* 思路 使用三次循环
* 第一次 原链表A-B-C 变成A-A`-B-B`-C-C`
* 第二次 处理random指针 当前新节点.random = 旧节点.random.next
* 第三次 拆分新老链表*/



public class N138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 第一轮：给每个旧节点后面插入新节点
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // 第二轮：给新节点设置 random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next; // ✅ 只改新节点！
            }
            cur = cur.next.next;
        }

        // 第三轮：拆分新旧链表（最关键）
        cur = head;
        Node newHead = head.next; // ✅ 先把新链表头存住
        while (cur != null) {
            Node copy = cur.next;
            cur.next = copy.next; // 旧链表指回原 next
            if (copy.next != null) {
                copy.next = copy.next.next; // 新链表串起来
            }
            cur = cur.next; // ✅ 指针往前走
        }

        return newHead; // ✅ 返回新链表
    }

    public static void main(String[] args) {
        var test = new N138();
        var node1 = new Node(1);
        var node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.next = null;
        node2.random = node2;
        test.copyRandomList(node1);
    }
}
