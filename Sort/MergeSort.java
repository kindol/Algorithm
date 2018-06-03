package Sort;

import java.util.Arrays;

public class MergeSort
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
        down(arr, new int[arr.length], 0, arr.length-1);            //后面的数组直接用了参数，所以这里要-1
    }

    public static void down(int[] arr, int[] tmp, int l, int r)
    {
        if (l == r)
            return;

        int mid = (l+r)/2;
        down(arr, tmp, l, mid);
        down(arr, tmp, mid+1, r);

        int x = l, y = mid + 1, nowLoc = l;
        while (x <= mid || y <= r)
        {
            if(x <= mid && (y > r || arr[x] < arr[y]))
                tmp[nowLoc] = arr[x++];
            else
                tmp[nowLoc] = arr[y++];
            nowLoc++;
        }

        for (int i = l; i <= r; i++)
            arr[i] = tmp[i];
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 53, 34, 0,2, 34, 5,6 ,8321, 12};
        sort1(arr);

        System.out.println(Arrays.toString(arr));
    }
}
