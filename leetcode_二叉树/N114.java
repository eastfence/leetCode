/*思路 找到左子树的最右侧节点 把右子树挂过去 在把整个左子树变成右子树*/

public class N114 {
    public void flatten(TreeNode root) {
        var cur = root;
        while (cur != null) {
            if (cur.left != null) {
                var tmp = cur.left;
                // 找到左子树的左右测节点
                while (tmp.right != null) {
                    tmp = tmp.right;
                }

                // 挂过去
                tmp.right = cur.right;

                // 反转
                cur.right = cur.left;
                cur.left = null;
            }
            // 移动节点
            cur = cur.right;
        }
    }
}
