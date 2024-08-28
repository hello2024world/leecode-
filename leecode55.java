public class leecode55 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int index = 0;
        boolean[] dp = new boolean[length + 1];
        if (length!=0){
            dp[0] = true;
        }


        while (index != length){
            if (index == 0){
                index++;
                continue;
            }
            //此时的index已经大于0
            //如果前一个位置的可以到达这个位置，说明可以到达最终的位置
            for (int t = index - 1;t >= 0;t--){
                if (nums[t] > index-1-t && dp[t] == true){
                    dp[index] = true;
                    break;
                }
            }
            index++;
        }
        return dp[index-1];
    }
}
