package Sort;

import java.util.Arrays;

public class QuickSort
{

    private static void swap(int[] arr, int j, int i)
    {
        if(i == j)
            return;
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
    }

    public static int getPivot(int l, int r)
    {
        return (l+r)/2;
    }

    //得到某一个值的确切位置
    public static int partition(int[] arr, int l, int r, int pivot)
    {
        while (l < r)
        {
            while (arr[l] < pivot) l++;
            while (l < r && arr[r] >= pivot) r--;               //这里的条件判断不能换
            swap(arr, l, r);
        }

        return l;
    }

    public static void down(int[] arr, int l, int r)
    {
        if(l >= r)
            return;

        int pivot = getPivot(l ,r);
        swap(arr, pivot, r);

        int part = partition(arr, l ,r, arr[r]);
        swap(arr, part, r);
        down(arr, l ,part-1);
        down(arr, part +1, r);
    }

    public static void sort1(int[] arr)
    {
        down(arr, 0, arr.length-1);
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 53, 34, 0,2, 34, 5,6 ,8321, 12};
        sort1(arr);

        System.out.println(Arrays.toString(arr));
    }

}
