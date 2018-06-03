package DynamicProgramming;

/*
最大字段和问题

考虑加不加当前这个数
公式为：b[j]表示a从0到j的最大字段和，如果为负责则只加入当前数a[j]
b[j] = max{b[j-1]+a[j], a[j]}

不能用b[j] = max{b[j-1], b[j-1]+a[j]}的公式想，因为是字段，连续的，所以不存在b[j-1],应该替换为a[j]
 */

public class MaxSum
{

    //b不需要为数组，只需要是常数即可
    public static int maxSum(int[] numbers)
    {
        int sum = 0, b = 0;
        for (int tmp: numbers)
        {
            b = Math.max(b+tmp, tmp);
            if(b > sum)
                sum = b;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(maxSum(new int[]{-2, 11, -4, 13, -5, -2}));
    }

}
