import java.util.ArrayList;
import java.util.List;

public class N46 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    int[] nums;


    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.used = new boolean[nums.length];
        backTrace();
        return result;
    }

    private void backTrace() {
        // 填满了
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);

            backTrace();

            // 回溯
            path.removeLast();
            used[i] = false;
        }
    }
}
