package DynamicProgramming;

/*
最长公共子序列
举个例子：
    若给定序列X={x1,x2,…,xm}，
    则另一序列Z={z1,z2,…,zk}，
    是X的子序列是指存在一个严格递增下标序列{i1,i2,…,ik} 使得对于所有j=1,2,…,k有：zj=xij。

思路：
站在答案的角度，有三个字符串，答案z，字符序列xi，yj
如果xi=yj，那么zk=xi=yj，则看z[k-1]是否为最长子序列
如果xi!=yj，且zk!=xi，则z是xi-1和yj的最长子序列（但不说yj一定在z里面！）
zk!=yj同理

转换为公式就是如代码
 */

public class LCSLength
{
    //参数c表示当前字符串xi和yj的最大公共子串长度，c的维度应该是(x.length+1)*(y.length+1)，b为记载子串的方向（实际记载了子串字符）,1为xi=yj，2为看x串，3为看y串
    public static void LCS(String x, String y, int[][] c, int[][] b)
    {
        for (int i = 1; i < x.length(); i++)
        {
            for (int j = 1; j < y.length(); j++)
            {
                if(x.charAt(i) == y.charAt(j))
                {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }
                else if (c[i-1][j] >= c[i][j-1])
                {
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }
                else
                {
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }
    }

    //算法的改进是进行空间优化，因为每一次都是利用上一行的数据，所以只需要创建两行长度为y.length+1的数组即可
}
