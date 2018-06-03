package NiuKe;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路1：
 * 二分查找到K，并从此数往左右扩散开计数，然而复杂度过大
 *
 * 思路2：
 * 由于是整数，所以可以两次二分查找 k+0.5 和 k-0.5，得到范围即可
 */

public class GetNumberOfK {

    public int getNumberOfK1(int [] array , int k) {
        if (array == null || array.length == 0)
            return 0;

        int res = 1, left = 0, right = array.length-1;
        int mid = (left + right) / 2;

        while (left < right){
            if (array[mid] == k)
                break;
            else if (array[mid] < k)
                left = mid + 1;
            else
                right = mid - 1;
            mid = (left + right) / 2;
        }

        if (array[mid] == k){
            for (left = mid - 1; left >= 0 && array[left] == k; res++, left--);
            for (right = mid + 1; right < array.length && array[right] == k; res++, right++);
        }else {
            res--;
        }

        return res;
    }

    /*public int getNumberOfK2(int [] array, int k){

    }*/

    public static void main(String[] args) {
        System.out.println(new GetNumberOfK().getNumberOfK1(new int[]{1,2,3,3,4,5,5,5,6,7,8,8,10}, 5));
    }

}
