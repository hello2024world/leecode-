/**
 * @author java learning start
 * @create 2026-11-11 10:42
 */
public class LeetCode209 {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     */
    public int minSubArrayLen(int target, int[] nums) {
        //双指针思路：
        //左指针限定子数组的开始位置；
        //右指针限定子数组的结束位置；
        //每次累加子数组所有元素的值，如果大于等于target，记录当前子数组的长度，并且左指针开始右移（重复判断）；
        //如果小于target，继续循环右移右指针
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            sum = sum + nums[i];
            while (sum >= target){
                if (left > i){
                    break;
                }
                minLength = Math.min(minLength,i - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
