/*73. 矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。*/

/*
 * 思路 使用首行首列标记法 先使用循环遍历出0所在的位置[m,n] 将0所在的首行n列置为0 首列m行置为0 再次循环矩阵 对应行和列 有标记就置为0*/

import java.util.Arrays;

public class N73 {
    public void setZeroes(int[][] matrix) {
        // 记录第一行是否存在0
        var line = 0;
        var column = 0;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                line = 1;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if  (matrix[0][i] == 0) {
                column = 1;
                break;
            }
        }

        // 先循环找出所有0的位置
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 已经找到了0所在的位置 那么接下来循环 找标记
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
                if (matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 根据标记 看是否处理第一行 第一列
        if  (line == 1) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if  (column == 1) {
            Arrays.fill(matrix[0], 0);
        }
    }

    public static void main(String[] args) {
        var test = new N73();
        test.setZeroes(new int[][]{{1, 0, 1}});
    }


}
