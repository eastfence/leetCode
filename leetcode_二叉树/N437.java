import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class N437 {


    public int pathSum(TreeNode root, int targetSum) {
        Stack<NewTreeNode> st = new Stack<>();
        int count = 0;
        if (root == null) {
            return count;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        // 把根节点加入栈中
        st.push(new NewTreeNode(root, 0, false));
        while (!st.isEmpty()) {
            var nNode = st.pop();
            var node = nNode.node;
            var currentNum = nNode.currentNum + node.val;

            if (!nNode.visita) {
                count += map.getOrDefault(currentNum - targetSum, 0);
                map.merge(currentNum, 1, Integer::sum);

                nNode.visita = true;
                st.push(nNode);

                if (node.right != null) {
                    st.push(new NewTreeNode(node.right, currentNum, false));
                }
                if (node.left != null) {
                    st.push(new NewTreeNode(node.left, currentNum, false));
                }
            } else {
                map.merge(currentNum, -1, Integer::sum);
            }
        }

        return count;
    }
}

class NewTreeNode {
    public boolean visita;
    public TreeNode node;
    public long currentNum;

    public NewTreeNode(TreeNode node, long currentNum, boolean visita) {
        this.node = node;
        this.currentNum = currentNum;
        this.visita = visita;
    }
}
