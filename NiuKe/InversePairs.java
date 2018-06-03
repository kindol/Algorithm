package NiuKe;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 利用归并排序，从小到大排
 * 先递归到底部，往上逐层排序，如果右子数组的数字小于左子数组的数字，则逆序数对加上右子数组剩余数字的个数，
 * 依次向上，数组内部的数字已经排好序而且逆序数对已经计数过
 */

public class InversePairs {

    private long result = 0;

    public void down(int[] array, int[] auxiliary, int l, int r){
        if (l == r)
            return;

        int mid = (l+r)/2;
        down(array, auxiliary, l, mid);
        down(array, auxiliary, mid+1, r);

        int x = l, y = mid+1, nowLoc = l;
        while (x <= mid || y <= r){
            if (x <= mid && (y > r || array[x] <= array[y]))
                auxiliary[nowLoc] = array[x++];
            else {
                if (x <= mid)
                    result = (result + mid - x + 1) % 1000000007;
                auxiliary[nowLoc] = array[y++];
            }
            nowLoc++;
        }

        for (x = l; x <= r; x++)
            array[x] = auxiliary[x];
    }

    public int inversePairs(int[] array) {

        int[] auxiliary = new int[array.length];
        down(array, auxiliary, 0, array.length-1);
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new InversePairs().inversePairs(new int[]{1,2,3,4,5,15,6,7,8,9,0,10,11,12,13}));
    }

}
