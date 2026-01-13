/*
*
* 42. 接雨水
困难
相关标签
premium lock icon
相关企业
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
*
* 核心理解点 计算左右两侧的高低不平的值
*
* */


public class leetcode042 {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = height[left];
        int right_max = height[right];
        while (left < right) {
            if (left_max < right_max) {
                res += left_max - height[left];
                left++;
                left_max = Math.max(left_max, height[left]);
            } else {
                res += right_max - height[right];
                right--;
                right_max = Math.max(right_max, height[right]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode042 a = new leetcode042();
        var b = a.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(b);

    }
}
