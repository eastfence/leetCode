import java.util.LinkedList;
import java.util.Queue;

public class N543 {
    int maxSum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        maxSum = Math.max(maxSum, left + right);
        return Math.max(left, right) + 1;
    }

}
