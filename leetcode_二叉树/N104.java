import java.util.LinkedList;
import java.util.Queue;

public class N104 {
    public int maxDepth(TreeNode root) {
        var depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            // 相当于把每个父节点循环 看是否有子节点
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
