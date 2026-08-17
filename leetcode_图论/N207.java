import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class N207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        var map = new HashMap<Integer, ArrayList<Integer>>();
        var score_nums = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            var score = prerequisite[0];
            var pre_score = prerequisite[1];
            map.computeIfAbsent(pre_score, _ -> new ArrayList<>()).add(score);
            score_nums[score]++;
        }

        // 找到度为0的课程
        for (int i = 0; i < numCourses; i++) {
            if (score_nums[i] == 0) {
                queue.offer(i);
            }
        }
        var visited = 0;
        while (!queue.isEmpty()) {
            var score = queue.poll();
            visited++;

            for (int next : map.getOrDefault(score, new ArrayList<>(0))) {
                score_nums[next]--;
                if (score_nums[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return visited == numCourses;
    }

    static void main() {
        var test = new N207();
        test.canFinish(2, new int[][]{{1, 0}});
    }
}
