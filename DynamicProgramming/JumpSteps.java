package DynamicProgramming;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。

思路：
很自然的思路是：
F(n) = F（n-1）+F(n-2)+...+F(1)

然而，这个公式还可以优化，因为
F(n-1) = F（n-2）+F(n-3)+...+F(1)

所以，最终的公式可以是
F(n) = F(n-1)*2
 */

public class JumpSteps
{
    public int JumpFloorII(int target) {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        int[] res = new int[target+1];
        res[0] = 0; res[1] = 1;
        for (int i = 2; i <= target; i++)
            res[i] = 2*res[i-1];
        return res[target];
    }
}
