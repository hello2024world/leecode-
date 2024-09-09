public class leecode78 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> current = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int start = 0;
        findSets(nums,start);
        return result;
    }
    public void findSets(int[] nums,int start){
        //每次把当前的集合放入结果集中
        result.add(new ArrayList<>(current));
        if (start >= nums.length){
            return;
        }
        for (int i = start;i < nums.length;i++){
            //把遍历的数加入到当前集合中
            current.add(nums[i]);
            //以这个值开始，不断的向后叠加数字到集合中
            findSets(nums, i+1);
            //函数回来计算时，把中间的值掠过
            //如果中间存在可以跳过的值
            current.removeLast();
        }
    }
}
