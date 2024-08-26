package com.atguigu.redis7.exam;

/**
 * @author shkstart
 * @create 2024-08-26 10:35
 */
public class leecode53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int sum = nums[0];
        int temp = 0;

        for (int i = 0;i < length;i++){
            //考虑单独成为一段，还是加上前面的一段
            //每次比较当前值，和相加值的大小
            //如果前一段的和加上当前值大于当前值，说明加上前一段符合题意
            temp = Math.max(temp + nums[i],nums[i]);
            sum = Math.max(sum,temp);
        }
        return sum;
    }
}
