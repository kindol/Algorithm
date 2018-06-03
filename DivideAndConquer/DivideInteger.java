package DivideAndConquer;

/*
整数划分问题
例如：6有以下11种划分方法
 6
 5+1
 4+2，4+1+1
 3+3，3+2+1，3+1+1+1
 2+2+2，2+2+1+1，2+1+1+1+1
 1+1+1+1+1+1
 */

public class DivideInteger
{
    public static int down(int n, int m)
    {
        if(n == 1 || m == 1)
            return 1;
        if(n < m)
            return down(n, n);
        if(n == m)
            return 1 + down(n, n-1);
        if (n > m && m > 1)
            return down(n-m, m)+down(n, m-1);

        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println(down(6, 6));
    }
}
