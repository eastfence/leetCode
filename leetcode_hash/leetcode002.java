import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode002 {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            map.computeIfAbsent(s, _ -> new ArrayList<>()).add(str);
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        leetcode002 l = new leetcode002();
        String[] strs = new String[]{"a"};
        List<List<String>> result = l.groupAnagrams(strs);
        System.out.println(result);
    }
}
