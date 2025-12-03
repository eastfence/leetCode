import java.util.HashSet;

public class leetcode003 {
    public int longestConsecutive(int[] nums) {
        /*结题思路 如果一个数组是[100, 90, 100, 200, 4, 200, 3, 2, 1]
         * 先去重
         * 由于遵循一个顺序x x-1 x-2 x-3 因此只需要判断尾即可 如不在序列中 说明是一个新的序列 在序列中说明此数组长度+1*/
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        var max_lenth = 0;
        for (int num : set) {
            // 找到头 开始找此顺序
            if (!set.contains(num - 1)) {
                var new_lenth = 0;

                var i = 0;
                while (true) {
                    if (set.contains(num + i)) {
                        new_lenth++;
                        i++;
                    } else {
                        break;
                    }
                }
                max_lenth = Math.max(max_lenth, new_lenth);
            }
        }
        return max_lenth;
    }

    public static void main(String[] args) {
        leetcode003 leetcode003 = new leetcode003();
        var max_value = leetcode003.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        System.out.println(max_value);
    }
}
