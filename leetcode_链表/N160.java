public class N160 {
    /*核心解题思路
    * 双指针 指针A从链表B开始走 走完B走A
    * 指针B从链表A开始走 走完A走B
    * 为什么这么做？
    * 1. 消除长度差
    * 2. 某个点当指针A和B所指向的node在内存中地址相等时 说明已经找到了交点*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        var pointerA = headA;
        var pointerB = headB;
        // 开始走
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB: pointerA.next;
            pointerB = pointerB == null ? headA: pointerB.next;
        }
        return pointerA;
    }
}
