package NiuKe;

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

思路：因为是二叉搜索树，所以左子树一定小于右子树
按照递归的思路，
最后一个值肯定是根，找到左子树和右子树，如果发现右子树的最右节点的下标没有到达根下标-1，说明非正常结果
 */

public class VerifySquenceOfBST
{
    private boolean helpJudge(int[] sequence, int left, int right)
    {
        //到达叶子节点
        if (left == right)
            return true;

        //分别得到左右子树，并且rightPart的下标应该到达right才对，因为右子树的值都大于根
        int leftPart = left;
        while (sequence[leftPart++] < sequence[right] && leftPart < right);
        int rightPart = leftPart;
        while (sequence[rightPart++] > sequence[right] && rightPart < right);

        if (rightPart < right)
            return false;

        //仅有左子树或者仅有右子树的情况
        if (leftPart == left || leftPart == right)
            return helpJudge(sequence, left, right-1);

        return helpJudge(sequence, left, leftPart-1) && helpJudge(sequence, leftPart, right-1);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        return helpJudge(sequence, 0, sequence.length-1);
    }

    //非递归实现
    /*
    本质上还是递归的思路
    因为是后续遍历，所以最右边的节点肯定是根，递归的思路是对于每一层右子树的最右叶子节点下标都需要为根下标-1
    有一个地方值得注意，那就是每个节点都可以当做根，
    所以从后往前遍历根，每一次都满足右子树的最右叶子节点下标都需要为根下标-1，
    到达终结条件下标为0则完成，即到达最左的叶子节点，完成遍历
     */
    public boolean VerifySquenceOfBST2(int [] sequence) {
        if (sequence.length == 0)
            return false;

        int root = sequence.length-1;
        while (root != 0)
        {
            int i = 0;
            while (sequence[i++] < sequence[root] && i < root);
            while (sequence[i++] > sequence[root] && i < root);

            if (i < root)
                return false;
            root--;
        }
        return true;
    }
}
