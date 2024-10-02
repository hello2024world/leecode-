public class leecode90 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> current = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findSubs(nums,0);
        return result;
    }
    public void findSubs(int[] nums,int index){
        if (!result.contains(current)){
            result.add(new ArrayList<>(current));
        }
        if (index >= nums.length){
            return;
        }
        for (int i = index;i < nums.length;i++){
            current.add(nums[i]);
            findSubs(nums,i+1);
            current.removeLast();
        }
    }
}
