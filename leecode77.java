public class leecode77 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> current = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        //回溯
        FindResult(n,k,0,current);
        return result;
    }
    public void FindResult(int n,int k,int start,LinkedList<Integer> current){
        //当子集元素为k的时候，加入到结果集中
        if (current.size() == k){
            result.add(new ArrayList<>(current));
        }
        if (start >= n){
            return;
        }
        for (int i = start;i < n;i++){
            current.add(i+1);
            FindResult(n, k, i+1, current);
            current.removeLast();
        }
    }
}
