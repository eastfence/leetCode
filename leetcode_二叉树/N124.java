public class N124 {

    public int maxValue = -Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxValue;
    }

    int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        var leftMax = Math.max(maxGain(node.left), 0);
        var rightMax = Math.max(maxGain(node.right), 0);

        var currentNodeMax = node.val + leftMax + rightMax;
        maxValue = Math.max(maxValue, currentNodeMax);
        return node.val + Math.max(leftMax, rightMax);
    }

}
