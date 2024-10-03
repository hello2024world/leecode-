public class leecode153 {
    /**
     * 寻找旋转排序数组的最小值，原先数组是排好序的
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        //用头尾双指针，
        //头指针和尾指针进行比较，如果头指针比尾指针更小，说明头指针指向的就是最小的
        //如果头指针比尾指针更大，指针分别向中间走
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length-1;
        if (nums[left] <= nums[right]){
            return nums[left];
        }
        while (left <= right){
            if (nums[left] < nums[right]){
                min = Math.min(nums[left],min);
                break;
            }else if (nums[left] > nums[right]){
                int temp = Math.min(nums[left],nums[right]);
                min = Math.min(temp,min);
                left++;
                right--;
            }else {
                min = Math.min(nums[left],min);
                left++;
                right--;
            }
        }
        return min;
    }
}
