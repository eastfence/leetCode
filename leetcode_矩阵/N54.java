/*
* 54. 螺旋矩阵
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
* */

import java.util.ArrayList;
import java.util.List;

public class N54 {
    /*定义四个边界 上下左右 从左到右扫完 上边界+1 从上往下扫完 右边界+1 直到所有边界收束 把中间的值加起来*/
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0;
        var bottom = matrix.length - 1;
        var right = matrix[0].length - 1;

        var result = new ArrayList<Integer>();

        while (true) {
            // 左->右
            for (int i = left; i <= right; i ++) {
                result.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            
            // 上->下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (--right < left) break;
            
            // 右->左
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;

            // 下->上
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return  result;
    }

    public static void main(String[] args) {
        var res = new N54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
