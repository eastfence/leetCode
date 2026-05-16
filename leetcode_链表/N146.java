import java.util.HashMap;

public class N146 {

    // 内部双向链表节点
    static class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final HashMap<Integer, Node> map;
    private final Node head, tail;
    private final int capacity;

    public N146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        addToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addToTail(node);
        } else {
            if (map.size() == capacity) {
                Node del = head.next;
                remove(del);
                map.remove(del.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToTail(newNode);
        }
    }

    // 移除一个节点
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 添加到尾部（最新使用）
    private void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}
