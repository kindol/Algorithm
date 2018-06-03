package NiuKe;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。

思路1：
简单的的思路，多创建两个同样长度的数组，遍历原本的数组，把单数放在数组1，偶数放在数组2，再放回即可

思路2：
在原数组上，while循环，从前往后找偶数，从后往前找单数，类似快排，找到则交换，但是这里需要多创建一个boolean数组记录哪些位置交换过，
再在交换过的位置上单数前后互换，偶数也同。
 */

public class ReorderArray
{

    public static void reOrderArray(int [] array)
    {
        int[] ji = new int[array.length];int i = 0;
        int[] ou = new int[array.length];int j = 0;
        for (int tmp: array)
        {
            if(tmp%2 == 1)
                ji[i++] = tmp;
            else
                ou[j++] = tmp;
        }
        int k = 0;
        for (k = 0; k < array.length && k < i; k++)
            array[k] = ji[k];
        for (j = 0; k < array.length; k++, j++)
            array[k] = ou[j];
    }

}
