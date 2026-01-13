/*
*
*
* 3. 无重复字符的最长子串
已解答
中等
相关标签
premium lock icon
相关企业
提示
给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
     *
     *
使用滑动窗口解题 使用HashSet判断字符是否在列表中
*
* */


import java.util.HashSet;

public class leetcode003 {

    public int lengthOfLongestSubstring(String s) {

        char[] arr = s.toCharArray();
        int temp1 = 0;
        int max_num = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                set.remove(arr[i - 1]);
            }
            while (temp1 <= arr.length - 1 && !set.contains(arr[temp1])) {
                set.add(arr[temp1]);
                temp1++;
            }
            max_num = Math.max(max_num, set.size());

        }
        return max_num;
    }

    public static void main(String[] args) {
        leetcode003 test = new leetcode003();
        var a = test.lengthOfLongestSubstring(" ");
        System.out.println(a);
    }


}