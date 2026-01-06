/*
* 三数之和
*
* 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode006 {
    public List<List<Integer>> test(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        // 固定一个数 找另外两个数
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            //如果所选的第一个数>0 后续的数都是>=这个数 不可能找到符合要求的数 直接跳出循环
            if (num > 0) {
                break;
            }
            // 去重 跳过重复的第一个数
            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            // 双指针找另外的两个数
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = num + nums[left] + nums[right];
                if (sum == 0) {
                    //找到了 存入
                    result.add(List.of(num, nums[left], nums[right]));

                    //去重 左边的数一样的跳过
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    //去重 右边的数一样的跳过
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //移动指针
                    right--;
                    left++;
                } else if (sum > 0) {
                    // 找的值偏大 右指针往前
                    right--;
                } else {
                    left++;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        leetcode006 test = new leetcode006();
        var a = test.test(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(a.toString());
    }
}
