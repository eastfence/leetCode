import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            var size = q.size();
            var l = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                var node = q.poll();
                l.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(l);
        }
        return result;
    }
}
