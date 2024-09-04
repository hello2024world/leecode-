public class leecode70 {
    public int climbStairs(int n) {
        //动态规划方案
        //每次可以爬一格楼梯或者两格楼梯
        //当前这个位置就由前一个位置或着前前个位置过来的
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n;i++){
            if (i == 1){
                dp[i] = dp[i-1] + 1;
            }else
                dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
