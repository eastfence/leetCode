/*
 * 解题关键 result[i] = 前缀积 * 后缀积    前缀积和后缀积是可以缓存 避免多次重复计算
 * 前缀积 = left[0] * left[1] * left[n-1]
 * 后缀积 = right[nums.length - 1] * right[nums.length - 2] * right[nums.length - n - 1]
 *
 *
 * 进阶解法： results[]中仅保留前缀积 缓存一个值当做后缀积 这样可以省去left和right两个数组
 * */


public class N238 {

    public int[] productExceptSelf(int[] nums) {

        var left = new int[nums.length];
        var right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = 1;
                right[nums.length - 1] = 1;
            } else {
                left[i] = left[i - 1] * nums[i - 1];
                right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - i];
            }
        }

        var result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public int[] productExceptSelf2(int[] nums) {

        /*优化版*/
        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }

        var right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        N238 n238 = new N238();
        n238.productExceptSelf2(new int[]{1, 2, 3, 4});
    }
}
