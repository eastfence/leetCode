/*
* 48. 旋转图像
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]
示例 2：


输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
* */

public class N48 {
    /*思路 顺时针旋转 先上下翻转再对角线交换
     * 逆时针旋转 先左右翻转再对角线交换
     * 旋转两次 先上下翻转 再左右翻转*/

    public void rotate(int[][] matrix) {
        // 上下翻转
        var mid = matrix.length / 2;
        for (int i = 0; i < mid; i++) {
            var temp = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = matrix[i];
            matrix[i] = temp;
        }

        // 对角线交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                var temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        var test = new N48();
        test.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }
}
