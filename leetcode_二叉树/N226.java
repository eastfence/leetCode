import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class N226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        var st = new Stack<TreeNode>();
        st.push(root);

        while (!st.isEmpty()) {
            var treeNode = st.pop();
            var leftTree = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = leftTree;

            if (treeNode.left != null) st.push(treeNode.left);
            if (treeNode.right != null) st.push(treeNode.right);
        }
        return root;
    }
}
