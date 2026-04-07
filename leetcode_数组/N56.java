import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class N56 {
    public int[][] merge(int[][] intervals) {
        // 先按照开头数字从小到大排序 排序后 所有可能的重叠区间一定是相邻的
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();

        for (int[] cur : intervals) {
            if (res.isEmpty()) {
                res.add(cur);
                continue;
            }

            // 拿到最后一个已经合并的区间
            int[] last = res.getLast();
            int endLast = last[1];

            if (cur[0] <= endLast) {
                // 重叠：合并，更新结束为最大值
                last[1] = Math.max(endLast, cur[1]);
            } else {
                // 不重叠：直接加入
                res.add(cur);
            }
        }

        // 正确转 int[][]
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 7}, {1, 4}};
        N56 n = new N56();
        var a = n.merge(arr);
        System.out.println(a);
    }
}
