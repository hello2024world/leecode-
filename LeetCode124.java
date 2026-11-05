/**
 * @author java learning start
 * @create 2026-11-05 10:25
 */
public class LeetCode124 {
    /**
     * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
     * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     *
     * 路径和 是路径中各节点值的总和。
     *
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     */

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        FindByLastOrder(root);
        return maxSum;
    }
    public int FindByLastOrder(TreeNode root){
        if (root == null){
            return 0;
        }

        //裁剪小于0的分支，小于0的分支求和之后必然变小
        int left  = Math.max(FindByLastOrder(root.left),  0);
        int right = Math.max(FindByLastOrder(root.right), 0);

        int sum = root.val + left + right;
        //计算以当前节点为拐点的最大路径和
        maxSum = Math.max(sum,maxSum);

        //返回内容应该是当前节点向下延伸的单边最大和路径
        return root.val + Math.max(left,right);
    }
}
