/*53. 最大子数组和
中等
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组是数组中的一个连续部分。

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [5,4,-1,7,8]
输出：23*/


/*
* 维护两个变量：currentSum（当前子数组和）、maxSum（全局最大和）；
遍历数组，对每个元素执行：
currentSum = max(当前元素, currentSum + 当前元素)（核心：如果当前累计和 + 当前元素 < 当前元素，说明累计和是负的，舍弃，重新从当前元素开始）；
maxSum = max(maxSum, currentSum)（更新全局最大值）；
最终 maxSum 就是结果（这里结果也是 6）。*/

public class N53 {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    //分治法 时间复杂度O(nlogn)
    public int maxSubArray2(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    /**
     * 分治法：求解 nums[left...right] 中的最大子数组和
     */
    private int divideAndConquer(int[] nums, int left, int right) {
        // 递归终止条件：区间长度为 1，最大子数组和就是当前元素
        if (left == right) {
            return nums[left];
        }

        // 1. 分：找到中间点，拆分成左右两个子区间
        int mid = left + (right - left) / 2; // 避免溢出，等价于 (left + right) / 2

        // 2. 治：递归求解左、右子区间的最大子数组和
        int leftMax = divideAndConquer(nums, left, mid);
        int rightMax = divideAndConquer(nums, mid + 1, right);

        // 3. 合并：求解跨左右区间的最大子数组和
        int crossMax = calculateCrossMax(nums, left, mid, right);

        // 4. 返回 3 个结果中的最大值
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    /**
     * 计算跨左右区间的最大子数组和（包含 mid 和 mid+1）
     */
    private int calculateCrossMax(int[] nums, int left, int mid, int right) {
        // 左半区间：从 mid 向左遍历，求后缀最大和
        int leftSuffixMax = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = mid; i >= left; i--) {
            currentSum += nums[i];
            leftSuffixMax = Math.max(leftSuffixMax, currentSum);
        }

        // 右半区间：从 mid+1 向右遍历，求前缀最大和
        int rightPrefixMax = Integer.MIN_VALUE;
        currentSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currentSum += nums[i];
            rightPrefixMax = Math.max(rightPrefixMax, currentSum);
        }

        // 跨区间的最大和 = 左后缀最大和 + 右前缀最大和
        return leftSuffixMax + rightPrefixMax;
    }

    public static void main(String[] args) {
        N53 n53 = new N53();
        var a = n53.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(a);
    }
}

