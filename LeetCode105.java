/**
 * @author java learning start
 * @create 2026-11-02 09:43
 */
import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {
    //=====================没啥思路，让claude写的=====================
    // 存储 inorder 中每个值对应的下标，用于 O(1) 定位根节点位置
    private final Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 给定两个整数数组 preorder 和 inorder ，
     * 其中 preorder 是二叉树的先序遍历，inorder 是同一棵树的中序遍历，
     * 请构造二叉树并返回其根节点。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 递归构建子树
     *
     * @param preorder 先序遍历数组
     * @param preStart 当前子树在先序遍历中的起始下标
     * @param preEnd   当前子树在先序遍历中的结束下标
     * @param inStart  当前子树在中序遍历中的起始下标
     * @param inEnd    当前子树在中序遍历中的结束下标
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // 先序遍历的第一个元素就是当前子树的根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中定位根节点，并计算左子树的节点个数
        int inRoot = indexMap.get(rootVal);
        int leftSize = inRoot - inStart;

        // 递归构建左、右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inStart, inRoot - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inRoot + 1, inEnd);

        return root;
    }
}
