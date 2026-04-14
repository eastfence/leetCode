/*
*240. 搜索二维矩阵 II
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。


示例 1：

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true
示例 2：

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false
* */


public class N240 {
    /*思路 从右上角的元素开始找 比这个元素大 就往下一列 小就往左找*/

    public boolean searchMatrix(int[][] matrix, int target) {
        var row = 0;
        var col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {row++;}
            else col--;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {

        //此写法在[[-5]]会造成数组下标越界
        var column = matrix[0].length;
        for (int[] ints : matrix) {
            // 右上角的数比较
            while (column > 0 && target < ints[column - 1]) {
                column--;
            }
            if (target == ints[column - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var test = new N240();
        test.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 30);
    }
}
