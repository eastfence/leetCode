import java.util.ArrayList;
import java.util.List;

public class N78 {
    public List<List<Integer>> subsets(int[] nums) {

        var res = new ArrayList<List<Integer>>();
        var path = new ArrayList<Integer>();

        backtrack(0, res, path, nums);
        return res;
    }

    private void backtrack(int start, ArrayList<List<Integer>> res, ArrayList<Integer> path, int[] nums) {
        res.add(new ArrayList<>(path));
        var lenth = nums.length;
        for (int i = start; i < lenth; i++) {
            path.add(nums[i]);
            backtrack(i + 1, res, path, nums);
            path.remove(path.size() - 1);
        }
    }

}
