package NiuKe;

/*
在一个二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

思路：
从右上角开始查找，当查的数字比当前数字大时，下移；否则，左移

终止条件：
出去边界，因为一直往左下走
 */

public class SearchIn2D
{

    public boolean Find(int target, int [][] array) {
        int rowNow = 0;
        int colNow = array[0].length-1;

        for(;rowNow < array.length && colNow >= 0;)
        {
            if(target == array[rowNow][colNow])
                return true;

            if(target > array[rowNow][colNow])
            {
                rowNow++;
                continue;           //需要直接continue是因为怕+1后越界
            }
            if (target < array[rowNow][colNow])
            {
                colNow--;
                continue;
            }
        }
        return false;
    }

}
