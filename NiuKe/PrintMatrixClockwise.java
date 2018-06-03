package NiuKe;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

思路：
记录四个顶点的位置，不断的顺时针，最后的结果是
单独一行（5*4）、单独一列（4*5）、单独一个元素（3*3）、什么都不剩（4*4）
 */

import java.util.ArrayList;

public class PrintMatrixClockwise
{
    public ArrayList<Integer> printMatrix(int [][] matrix)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1;            //left与top组成左上、right与bottom组成右下（实际已经是4个顶点）

        while ((left < right) && (top < bottom))
        {
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            for (int i = top+1; i <= bottom; i++)           //从这里开始要+1
                result.add(matrix[i][right]);
            for (int i = right-1; i >= left; i--)
                result.add(matrix[bottom][i]);
            for (int i = bottom-1; i > top; i--)            //这里的i不能=top
                result.add(matrix[i][left]);

            left++;
            right--;
            top++;
            bottom--;
        }

        if ((left == right) && (top < bottom))              //仅剩一列
        {
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
        }

        if((top == bottom) && (left < right))               //仅剩一行
        {
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);
        }

        if ((top == bottom) && (left == right))             //仅剩一个元素
        {
            result.add(matrix[left][top]);
        }

        return result;
    }

    public static void main(String[] args)
    {

    }
}
