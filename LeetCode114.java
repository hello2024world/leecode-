import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author java learning start
 * @create 2026-10-31 10:15
 */
public class LeetCode114 {
    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */
    public void flatten(TreeNode root) {
        //要求是在原链表基础上进行改动！！！

        //先序遍历作为基础
        List<TreeNode> list = new ArrayList<>();
        findNodeInOrder(root,list);
        //使用一个前置指点存储，方便赋予右节点指针
        if (list.size() < 1){
            return;
        }
        TreeNode pre = list.get(0);
        for (int i = 1;i < list.size();i++){
            pre.right = list.get(i);
            pre.left = null;
            pre = pre.right;
        }
    }

    /**
     * 先序遍历
     * @param root
     */
    public void findNodeInOrder(TreeNode root,List<TreeNode> list){
        if (root == null){
            return;
        }
        list.add(root);
        findNodeInOrder(root.left,list);
        findNodeInOrder(root.right,list);
    }
}

