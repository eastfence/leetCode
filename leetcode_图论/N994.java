import java.util.LinkedList;
import java.util.Queue;

public class N994 {
    public int orangesRotting(int[][] grid) {
        //先扫描一边 找到所有的腐烂橘子
        var result = 0;
        //健康的橘子
        var freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        var rows = grid.length;
        var cols = grid[0].length;
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        var pos = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //对腐烂的橘子进行广度遍历
        while (!queue.isEmpty()) {
            var size = queue.size();
            var success = false;
            for (int m = 0; m < size; m ++) {
                var bad = queue.poll();
                for (var p : pos) {
                    var ii = bad[0] + p[0];
                    var jj = bad[1] + p[1];
                    if (ii < 0 || ii >= rows || jj < 0 || jj >= cols || grid[ii][jj] != 1) {
                        continue;
                    }
                    success = true;
                    freshCount--;
                    grid[ii][jj] = 2;
                    queue.add(new int[]{ii, jj});
                }
            }
            if (success) result++;
        }
        return freshCount > 0 ? -1 : result;
    }
}
