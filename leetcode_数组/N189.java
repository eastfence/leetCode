import java.util.Arrays;

/*
* 向右轮转 k 位= 把最后 k 个元素整体搬到最前面
三次反转就是用反转操作实现 “把最后 k 个移到前面”：
整体反转 → 最后 k 个跑到最前面，但顺序反了
反转前 k 个 → 把顺序正回来
反转后面 n−k 个 → 把剩下的也正回来
* */


public class N189 {
    public void rotate(int[] nums, int k) {
        // 计算轮转次数 k
        int len = nums.length;
        k = k % len;

        // 整个反转
        reverse(nums, 0, len - 1);
        // 前k个反转
        reverse(nums, 0, k - 1);
        // 后n-k个反转
        reverse(nums, k, len - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end) {
        /*实现交换的方法*/
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        N189 n189 = new N189();
        var nums =  new int[]{1, 2, 3, 4, 5, 6, 7};
        n189.rotate(nums, 3);
    }
}
