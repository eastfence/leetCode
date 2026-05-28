import java.util.Stack;

public class N105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var st = new Stack<TreeNode>();
        var inor_index = 0;
        var root = new TreeNode(preorder[0]);
        st.push(root);

        for (var i = 1; i < preorder.length; i++) {
            var node = new TreeNode(preorder[i]);
            TreeNode parent = null;
            // 如果栈顶 == 中序当前值 → 弹出，说明是右子树
            while (!st.isEmpty() && st.peek().val == inorder[inor_index]) {
                inor_index++;
                parent = st.pop();
            }
            // 父节点不为空 → 是右孩子
            if (parent != null) {
                parent.right = node;
            }
            // 父节点为空 → 是左孩子
            else {
                st.peek().left = node;
            }
            st.push(node);
        }
        return root;
    }
}
