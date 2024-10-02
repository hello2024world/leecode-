public class LeecodeTest152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int[] dp = new int[length];
        int[] minArr = new int[length];
        dp[0] = nums[0];
        minArr[0] = nums[0];
        for (int i = 1;i < length;i++){
            dp[i] = Math.max(Math.max(dp[i-1] * nums[i],nums[i]),Math.max(minArr[i-1] * nums[i],nums[i]));
            minArr[i] = Math.min(Math.min(dp[i-1] * nums[i],nums[i]),Math.min(minArr[i-1] * nums[i],nums[i]));
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
