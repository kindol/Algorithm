package NiuKe;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：
 * 由于是丑数，由题意，丑数=2^p * 3^q * 5^r
 * 丑数有从小而大，由于是计算出第n个丑数，所以需要先得到前面的小的数，再计算后面的大的数
 * 利用到了前面的小的数，所以可以使用DP
 */

public class UglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index < 7)                              //7之前的所有数都是丑数
            return index;

        int t2 = 0, t3 = 0, t5 = 0;                 //分别表示2、3、5头上的次方p、q、r，当前最大的数就是由这几个次方得来的，而其同时可以作为下标，表示当前下标还未乘上ti
        int[] result = new int[index];
        result[0] = 1;

        for (int i = 1; i < index; i++)             //i表示第i个丑数，第i个丑数由前面计算可得，而计算只能是前面的数乘以2、3、5之一
        {
            result[i] = Math.min(result[t2]*2, Math.min(result[t3]*3, result[t5]*5));

            if (result[i] == result[t2]*2)  t2++;
            if (result[i] == result[t3]*3)  t3++;
            if (result[i] == result[t5]*5)  t5++;
        }

        return result[index-1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().GetUglyNumber_Solution(8));
    }

}
