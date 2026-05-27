/*依旧中序遍历 保存n值 每次扫描节点n+1 直到=k 返回当前节点的值*/

import java.util.Stack;

public class N230 {
    public int kthSmallest(TreeNode root, int k) {
        var n = 0;
        var st = new Stack<TreeNode>();
        var cur = root;

        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            n++;
            if (n == k) return cur.val;
            cur = cur.right;
        }
        return 0;
    }
}
