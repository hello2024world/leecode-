/**
 * @author java learning start
 * @create 2026-11-16 15:14
 */
public class Test16 {
    /**
     *  输入一个非负整数数组 nums ，最初位于数组的第一个下标 。
     *  数组中的每个元素代表在该位置可以跳跃的最大长度。
     *  判断是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false
     * 	示例 1：
     * 		输入：nums = [2,3,1,1,4]
     * 		输出：true
     * 	示例 2：
     * 		输入：nums = [3,2,1,0,4]
     *
     */
    public boolean Salution(int[] nums){
        if (nums.length == 1) return true;
        int sum = 0;

        //sum是动态变换的，每次获取到最大长度的时候都应该延长可以到达的距离
        for(int i = 0; i <= sum;i++){
            //比较当前位置索引+当前位置值 和 历史最大和之间的大小
            //  当前位置索引+当前位置值之和，表示可以从当前位置到达的最远距离
            sum = Math.max(sum, nums[i] + i);
            if (sum >= nums.length-1){
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Test16 t1 = new Test16();
        boolean b = t1.Salution(new int[]{3,2,1,0,4});
        System.out.println(b);
    }
}
