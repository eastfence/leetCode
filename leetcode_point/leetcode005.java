/*
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
* */

/*
左指针指向数组开头 右指针指向数组末尾
面积公式为 (right - left) * Math.min(nums[left], nums[right])
面积的影响有两点 1.两个边的距离 2. 长度最小的边
因此 移动最小边长的边 判断面积的变化
* */

public class leetcode005 {
    public int test(int[] nums) {
        var left = 0;
        var right = nums.length - 1;
        // 此值存放面积
        var temp = 0;
        while (left < right) {
            var nbs = (right - left) * Math.min(nums[left], nums[right]);
            if (nbs > temp) {
                temp = nbs;
            }
            // 移动边长最小的
            if (nums[left] <= nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        leetcode005 test001 = new leetcode005();
        var temp = test001.test(nums);
        System.out.println(temp);
    }

}
