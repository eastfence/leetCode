import java.util.Arrays;

public class N41 {
    public int firstMissingPositive(int[] nums) {
        var len = nums.length;
        for (int i = 0; i < len; i++) {
/*             n放在n-1处 同时交换 需要遍历交换 如[5,6,2,3,4] 5放在4下标 下标为4的值是4 要放在3下标 以此类推
             核心理念 当前值<=0不处理 当前值越界不处理 当前值和要交换的值相等不处理 如果都不满足 那么将当前值的下标与当前值-1对应的下标进行交换
             必须使用whlie 是因为如果是if 那么交换只能进行一次 交换后nums[i]的值发生了变化 再次判断能否进行交换 这样交换更彻底*/
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    void swap(int[] nums, int i, int j) {
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        var res = new N41().firstMissingPositive(new int[]{3,4,-1,1});
        System.out.println(res);
    }
}
