package NiuKe;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。

思路：
中序遍历，非递归，修改当前节点与前一个节点的指针指向

 */

import java.util.Stack;

public class BinaryTreeToLinks
{
    public TreeNode Convert(TreeNode pRootOfTree)
    {
        if (pRootOfTree == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();          //记录路径
        TreeNode now = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;

        while (now != null || !stack.isEmpty())
        {
            while (now != null)                         //压到相对于当前根的最左下
            {
                stack.push(now);
                now = now.left;
            }

            //对堆中每个节点处理
            now = stack.pop();
            if (isFirst)
            {
                pRootOfTree = now;
                pre = now;
                isFirst = false;
            }else
            {
                pre.right = now;
                now.left = pre;
                pre = now;
            }

            now = now.right;                            //栈中添加右节点
        }

        return pRootOfTree;
    }
}
