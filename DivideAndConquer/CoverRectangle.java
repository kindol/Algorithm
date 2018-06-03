package DivideAndConquer;

/*
矩阵覆盖：
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

递归思路思考：
n放横（长为n）
每次如果竖着，那么只能放一个，也就是-1；
每次如果横着，那么每次放两个，也就是-2

重点还是终止条件：
如果为0，返回0，下面没有可以解决的方案了
如果为1，返回1，仅有一个放法
如果为2，返回2，有两种放法
 */

public class CoverRectangle
{
    public int RectCover(int target) {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if (target == 2)
            return 2;
        return RectCover(target-1) + RectCover(target-2);
    }

    public int RectCover2(int target)
    {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if (target == 2)
            return 2;
        int[] res = new int[target+1];
        res[0] = 0; res[1] = 1; res[2] = 2;
        for (int i = 3; i <= target; i++)
            res[i] = res[i-1] + res[i-2];
        return res[target];
    }

}
