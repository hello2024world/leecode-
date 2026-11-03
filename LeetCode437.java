/**
 * @author java learning start
 * @create 2026-11-03 10:12
 */
public class LeetCode437 {
    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     *
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     */
    int sum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        findByLeftOrder(root,targetSum);
        return sum;
    }

    /**
     * 负责进行前序遍历，遍历每个节点
     * @param root
     * @param target
     */
    public void findByLeftOrder(TreeNode root,int target){
        if(root == null) return;

        //todo
        //一个能判断当前节点向下求和是否存在目标值的方法
        DeepFindOrder(root,target,0);

        findByLeftOrder(root.left,target);
        findByLeftOrder(root.right,target);
    }

    /**
     * 深序遍历当前节点的所有子节点
     * @param root
     * @param target
     * @param sumValue
     */
    public void DeepFindOrder(TreeNode root,int target,long sumValue){
        if (root == null) return;

        //注意数值范围，int类型相加可能超出范围
        sumValue = sumValue + root.val;
        if (sumValue == target){
            sum++;
        }

        DeepFindOrder(root.left,target,sumValue);
        DeepFindOrder(root.right,target,sumValue);
    }
}
