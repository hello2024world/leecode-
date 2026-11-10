/**
 * @author java learning start
 * @create 2026-11-10 10:24
 */
public class LeetCode977 {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     */
    public int[] sortedSquares(int[] nums) {
        //通过左右双指针去逐步获取逆序的结果
        //每次比较左右双指针位置的平方值，
        //取大值放入，然后左指针右移或者右指针左移
        int left = 0;
        int right = nums.length-1;
        int[] results = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right){
            int rightValue = nums[right] * nums[right];
            int leftValue = nums[left] * nums[left];
            if (leftValue < rightValue){
                results[index] = rightValue;
                right--;
            }else {
                results[index] = leftValue;
                left++;
            }
            index--;
        }
        return results;
    }
}
