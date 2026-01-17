/*
*
*438. 找到字符串中所有字母异位词
中等
相关标签
premium lock icon
相关企业
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
*
*
*
*
*
*
* */


import java.util.*;

public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0; // 改用 0 作为初始左指针，更易理解
        int count = p.length(); // 记录还需要匹配的字符总数，简化判断
        for (int right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);
            // 若当前字符在p中，且剩余匹配数>0，减少count
            if (map.containsKey(cRight) && map.get(cRight) > 0) {
                count--;
            }
            // 无论是否在p中，都减少对应频率（不在p中会变为负数）
            map.put(cRight, map.getOrDefault(cRight, 0) - 1);

            // 核心：窗口不合法时，持续收缩左指针（高效移动，不是单次1位）
            while (map.getOrDefault(s.charAt(left), 0) < 0 || (right - left + 1) > p.length()) {
                char cLeft = s.charAt(left);
                map.put(cLeft, map.getOrDefault(cLeft, 0) + 1);
                // 若恢复的字符是p中需要的，增加count
                if (map.containsKey(cLeft) && map.get(cLeft) > 0) {
                    count++;
                }
                left++; // 持续右移左指针，直到窗口合法
                if (left == s.length()) {
                    break;
                }
            }

            // 当需要匹配的字符总数为0，说明完全匹配
            if (count == 0) {
                ans.add(left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode438 leetcode438 = new leetcode438();
        var s = "acdcaeccde";
        var p = "c";
        var results = leetcode438.findAnagrams(s, p);
        System.out.println(results);
    }
}
