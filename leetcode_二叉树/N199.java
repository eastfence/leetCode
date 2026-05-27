import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*层序遍历 入队时先放右 如果右为空 再放左*/
public class N199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        var result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
        }
        return result;
    }
}
