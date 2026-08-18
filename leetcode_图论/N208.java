/*
* 为什么用数组 children[26]？
题目说只包含小写英文字母，所以用固定长度 26 的数组最快，索引直接用 c - 'a'。
如果字符集不确定（比如含大写、数字、中文），就把 TrieNode[] 换成 HashMap<Character, TrieNode>。
*
*
* */


public class N208 {

    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public N208() {
        root = new TrieNode();
    }

    // 插入：沿着字符往下走，没有就新建，最后标记结尾
    public void insert(String word) {
        var node = root;
        for (char c: word.toCharArray()) {
            var idx = c - 'a';
            if (node.nodes[idx] == null) {
                node.nodes[idx] = new TrieNode();
            }
            node = node.nodes[idx];
        }
        node.isEnd = true;

    }

    // 精确查找：必须存在路径，且终点是单词结尾
    public boolean search(String word) {
        var node = root;
        for (char c: word.toCharArray()) {
            int idx = c - 'a';
            if (node.nodes[idx] == null) {
                return false;
            }
            node = node.nodes[idx];
        }
        return node.isEnd;
    }

    // 前缀查找：只要路径存在就行
    public boolean startsWith(String word) {
        var node = root;
        for (char c: word.toCharArray()) {
            var idx = c - 'a';
            if (node.nodes[idx] == null) {
                return false;
            }
            node = node.nodes[idx];
        }
        return true;
    }
}
