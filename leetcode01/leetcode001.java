import java.util.HashMap;

static class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] results = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            int result = map.getOrDefault(temp, -1);
            if (result >= 0) {
                results[0] = i;
                results[1] = result;
            } else {
                map.put(nums[i], index);
            }
            index++;
        }
        return results;
    }
    //简洁版本
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return nums;
    }
}


public static void main(String[] args) {
    Solution s = new Solution();
    int[] results = s.twoSum2(new int[]{2, 7, 11, 15}, 9);
    System.out.println(Arrays.toString(results));
}