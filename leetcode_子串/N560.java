/*
560. 和为 K 的子数组
中等
相关标签
premium lock icon
相关企业
提示
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。

示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2
* */

/*
* 解题思路
* 一、核心思路
最优解：前缀和 + 哈希表（无法用滑动窗口，数组含负数 / 零破坏和的单调性）
二、核心原理
前缀和定义：curPreSum 表示数组从索引 0 到当前索引的累加和，额外补充虚拟前缀和 0（处理从数组开头的子数组）。
区间和转化：子数组 [i,j] 的和 = curPreSum[j] - curPreSum[i-1]。
题目需求转化：要找和为 k 的子数组，即 curPreSum[j] - curPreSum[i-1] = k，变形为 curPreSum[i-1] = curPreSum[j] - k。
三、哈希表作用
存储规则：key = 前缀和，value = 该前缀和出现次数。
初始化：map.put(0, 1)（对应虚拟前缀和）。
核心操作：遍历中查询 curPreSum - k，若存在则累加对应 value 到结果（即当前符合条件的子数组数）。
四、执行流程（精简）
初始化哈希表、当前前缀和、结果计数器。
遍历数组，累加得到 curPreSum。
查询 curPreSum - k，更新结果。
更新哈希表中当前前缀和的出现次数。
遍历结束返回结果。
五、时间 / 空间复杂度
时间：O (n)（仅遍历数组一次，哈希表操作 O (1)）。
空间：O (n)（最坏存储所有前缀和）。
* */

import java.util.HashMap;

public class N560 {
    public int subarraySum(int[] nums, int k) {

        // 思路 [1,2,3] k = 3 p[0] = 1  p[1] = 1 + 2 = 3 p[2] = 1 + 2 + 3 = 6
        // 那么k出现的次数就是p[1]   p[2] - p[1]
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始map
        map.put(0, 1);
        // 当前前缀和
        int res = 0;
        int results = 0;
        for (int num : nums) {
            res += num;
            int temp = res - k;
            if (map.containsKey(temp)) {
                results += map.get(temp);
            }

            map.put(res, map.getOrDefault(res, 0) + 1);
        }

        return results;
    }

    public static void main(String[] args) {
        N560 n560 = new N560();
        var results = n560.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(results);
    }
}
