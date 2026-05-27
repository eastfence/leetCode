import java.util.ArrayList;
import java.util.Stack;

public class N98 {
    public boolean isValidBST(TreeNode root) {
        // 前序遍历检查数组是否递增

        var st = new Stack<TreeNode>();
        var l = new ArrayList<Integer>();
        var cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            l.add(cur.val);
            cur = cur.right;
        }

        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) <= l.get(i-1)) {
                return false;
            }
        }
        return true;
    }
}
