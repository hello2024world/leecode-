import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class leecode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //先进行从小到大排序
        Arrays.sort(nums);
        //每次固定第一个数，后面的数采用双指针进行查询
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i < length-1;i++){
            //如果第一个数就大于0，后面就找不到答案了
            if(nums[i] > 0){
                break;
            }
            //如果和前一个数相等，只能找到重复的
            if ((i > 0 && nums[i] == nums[i-1])){
                continue;
            }
            int left = i+1;
            int right = length-1;
            //双指针遍历
            while (left < right){
                //如果三者相加小于0，left++
                if (nums[i] + nums[left] + nums[right] < 0){
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    //如果大于0，right--
                    right--;
                }else {
                    //正好等于0=============符合题意
                    //后续不会有别的符合
                    List<Integer> mid_res = new ArrayList<>();
                    mid_res.add(nums[i]);
                    mid_res.add(nums[left]);
                    mid_res.add(nums[right]);
                    res.add(mid_res);
                    //如果此时出现了与之前相同的数，要么没有答案，要么是重复的结果
                    while (left < right&& nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right&& nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }

            }
        }
        return res;
    }
}
