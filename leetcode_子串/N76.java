/*
*
76. 最小覆盖子串
困难
相关标签
给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。

测试用例保证答案唯一。

示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。
* */

import java.util.HashMap;

public class N76 {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 满足need数量要求的字符个数
        int temp = 0;
        // 最小窗口的起始索引
        int start = 0;
        // 最小窗口长度（初始无穷大）
        int maxLen = Integer.MAX_VALUE;

        // 右指针开始移动 寻找
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;

            // 仅处理t中存在的字符（无关字符直接跳过）
            if (map.containsKey(c)) {
                // 当window中该字符的数量 == need中的数量时，valid+1（注意：只有相等时才+1，避免重复）
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(map.get(c))) {
                    temp++;
                }
            }

            // 缩左指针：窗口满足条件（包含t所有字符），尝试缩小窗口
            while (temp == map.size()) {
                // 更新maxLen的值
                if (right - left < maxLen) {
                    start = left;
                    maxLen = right - left;
                }

                // 移出左指针指向的字符
                char d = s.charAt(left);
                left++;

                // 只处理map中有的字符
                if (map.containsKey(d)) {
                    // 当window中该字符的数量 == need中的数量时，移出后valid-1（否则不影响）
                    if (window.get(d).equals(map.get(d))) {
                        temp--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return maxLen == Integer.MAX_VALUE ? "" : s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        N76 n76 = new N76();
        var a = n76.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(a);
    }
}
