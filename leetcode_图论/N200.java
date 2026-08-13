/*
 * 把网格想象成一片海域，每遇到一块陆地 '1'，就说明发现了一个新岛屿。然后把这个岛屿所有相连的陆地都"淹没"（标记为已访问），继续扫描。*/


import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class N200 {
    public int numIslands(char[][] grid) {
        var result = 0;
        var rows = grid.length;
        var cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(i, j, rows, cols, grid);
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, int rows, int cols, char[][] grid) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, rows, cols, grid);
        dfs(i - 1, j, rows, cols, grid);
        dfs(i, j + 1, rows, cols, grid);
        dfs(i, j - 1, rows, cols, grid);
    }


    // bfs
    private int bfs(char[][] grid) {
        var result = 0;
        Queue<Integer[]> queue = new LinkedBlockingQueue<>();
        var rows = grid.length;
        var cols = grid[0].length;

        //定义四个方向
        var poss = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    queue.add(new Integer[]{i, j});
                    while (!queue.isEmpty()) {
                        var i_j_l = queue.poll();
                        var ii = i_j_l[0];
                        var jj = i_j_l[1];
                        for (var pos : poss) {
                            var p_i = ii + pos[0];
                            var p_j = jj + pos[1];
                            if (p_i < 0 || p_i >= rows || p_j < 0 || p_j >= cols || grid[p_i][p_j] != '1') {
                                continue;
                            }
                            grid[p_i][p_j] = '0';
                            queue.add(new Integer[]{p_i, p_j});
                        }
                    }
                }
            }
        }
        return result;
    }
}
