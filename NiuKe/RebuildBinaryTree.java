package NiuKe;

/*
重建二叉树：
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

 思路：
递归：
    前序遍历得到根，中序遍历区分左右，以此往下；在最终的时候，也就是函数头创建新的节点并返回
终止条件：
    pre数组长度1
 */

public class RebuildBinaryTree
{

    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val)
        {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        if(pre.length == 1)
            return root;

        int j = 0;
        for(; in[j] != root.val; j++);                  //找到根节点在in中的位置

        if(j > 0)                                       //含有左子树
        {
            int[] pr = new int[j];
            int[] ino = new int[j];
            for (int i = 0; i < j; i++)
            {
                pr[i] = pre[i+1];
                ino[i] = in[i];
            }
            root.left = reConstructBinaryTree(pr, ino);
        }else
        {
            root.left = null;
        }

        if(j < in.length-1)                             //含有右子树
        {
            int[] pr = new int[pre.length-j-1];
            int[] ino = new int[pre.length-j-1];
            for (int i = j+1; i < pre.length; i++)
            {
                pr[i-j-1] = pre[i];
                ino[i-j-1] = in[i];
            }
            root.right = reConstructBinaryTree(pr, ino);
        }else
        {
            root.right = null;
        }
        return root;
    }
}
