package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 思路：
 * 递归
 */

public class NumTrees2 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        return create(1, n);
    }

    private ArrayList<TreeNode> create(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++){
            ArrayList<TreeNode> leftTree = create(start, i-1);
            ArrayList<TreeNode> rightTree = create(i+1, end);

            /**
             * 遍历每一种左子树和右子树产生的可能组合，但根节点是不变的
             */
            for (TreeNode treeNode : leftTree)
                for (TreeNode treeNode1: rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = treeNode;
                    root.right = treeNode1;
                    res.add(root);
                }
        }

        return res;
    }

}
