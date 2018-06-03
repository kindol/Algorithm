package DynamicProgramming;

/*
矩阵连乘问题
事实上也可以转换为带有备忘录的递归方法
 */

public class Strassen
{

    //参数解释：p为矩阵的维，matrix为矩阵，selectPoint为矩阵在对应位置matrix(i, j)所选的分割点
    public static void MatrixChain(int[] p, int[][]matrix, int[][]selectPoint)
    {
        for (int i = 0; i < matrix.length; i++)
            matrix[i][i] = 0;

        //以斜对角线的计算方式不断往上推, r表示元素个数也就是j-i+1，比如matrix[1,2]则r=2
        for(int r = 2; r <= matrix.length; r++)
        {
            for(int i = 1; i < matrix.length-r+1; i++)
            {
                int j = i+r-1;          //j表示matrix[i][j]位置对应的值
                matrix[i][j] = matrix[i][i] + matrix[i+1][j] + p[i-1]*p[i]*p[j];            //先赋初始值，否则后面无法选取最小值
                selectPoint[i][j] = i;

                //k从i+1开始遍历，因为前面已经写过了k=i的情况
                for (int k = i+1; k < j; k++)
                {
                    int tmp = matrix[i][k] + matrix[k+1][j] + p[i-1]*p[k]*p[j];              //这些需要变为i-1，而不是i
                    if(tmp < matrix[i][j])
                    {
                        matrix[i][j] = tmp;
                        selectPoint[i][j] = k;
                    }
                }
            }
        }
    }

}
