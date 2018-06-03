package Sort;

import java.util.Arrays;

public class InsertSort
{

    private static void swap(int[] arr, int j, int i)
    {
        if(i == j)
            return;
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
    }

    public static void sort1(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--)
                swap(arr, j, j-1);
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 53, 34, 0,2, 34, 5,6 ,8321, 12};
        sort1(arr);

        System.out.println(Arrays.toString(arr));
    }

}
