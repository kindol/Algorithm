package NiuKe;

/*
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

思路：
一步步递归下去，当target值为0则新建一个list加入all即可，否则继续左右递归，
在左右递归结束后应该删除末尾节点，因为此时会返回上一层，当前层的节点已无用

可以提前新建一个ArrayList<ArrayList<Integer>>和临时存储队列ArrayList<Integer>
 */

import java.util.ArrayList;

public class PathOfSum
{
    ArrayList<ArrayList<Integer>> all = new ArrayList<>();
    ArrayList<Integer> road = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return all;
        target -= root.val;
        road.add(root.val);

        if (target == 0 && root.left == null && root.right == null)
            all.add(new ArrayList<>(road));
        FindPath(root.left, target);
        FindPath(root.right, target);
        road.remove(road.size()-1);
        return all;
    }
}
