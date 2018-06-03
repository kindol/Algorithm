package Sort;

import java.util.Arrays;

public class BubbleSort
{

    public static void sort1(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length-i-1; j++)        //-1是因为跟后面的数做对比会+1
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
    }

    public static void sort2(int[] arr)
    {
        boolean flg = false;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length-i-1; j++)        //-1是因为跟后面的数做对比会+1
            {
                if (arr[j] > arr[j+1])
                {
                    swap(arr, j, j+1);
                    flg = true;
                }
            }
            if (!flg)                           //如果没有交换那就表示全部排序完成
                break;
            flg = false;                         //重置flg
        }

    }

    public static void sort3(int[] arr)
    {
        int k, flg = arr.length;

        while(flg > 0)
        {
            k = flg;
            flg = 0;

            for(int i = 1; i < k; i++)          //此时从1开始比较容易写代码
            {
                if(arr[i] < arr[i-1])
                {
                    swap(arr, i ,i-1);
                    flg = i;
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i)
    {
        if(i == j)
            return;
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 53, 34, 0,2, 34, 5,6 ,8321, 12};
        sort3(arr);

        System.out.println(Arrays.toString(arr));
    }
}
