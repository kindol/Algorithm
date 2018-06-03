package Sort;

import java.util.Arrays;

public class ShellSort
{

    private static void swap(int[] arr, int j, int i)
    {
        if(i == j)
            return;
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
    }

    /*
    充分利用了insertSort，从后往前插入元素
     */

    public static void sort1(int[] arr)
    {
        for (int gap = arr.length/2; gap > 0; gap /= 2)
            for(int i = gap; i < arr.length; i++)
                for(int j = i-gap; j >= 0 && arr[j] > arr[j+gap]; j -= gap)
                    swap(arr, j, j+gap);
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 53, 34, 0,2, 34, 5,6 ,8321, 12};
        sort1(arr);

        System.out.println(Arrays.toString(arr));
    }

}
