package NiuKe;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 *
 * 思路：
 * 碰到数字相同的问题，考虑按位异或运算
 * 如果是一个只出现了一次的数，那么跟0异或得到的是那个数
 * 而如果是两个数，那么最后剩下的就是两个数的异或
 * 得到的结果寻找第一个1，也就是两个数第一个不同的位，依此可以区分此两个数
 * 同个此不同的位，将原数组分成两类，这两类会分别包含对应的只出现的数字
 *
 * 另有一个变形：
 * 一个连续的从1开始的整型数组里除了一个数字出现两次之外，其他的数字都只出现了一次。
 * 例如——总共101个数，数字为从0-99
 *
 * 思路1：
 * hash
 * 思路2：
 * 加起来再减去求和公式的和
 */

public class FindNumsAppearOnce {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
        }

        int bitResult = 0;          //异或过所有数字之后
        for (int i = 0; i < array.length; i++)
            bitResult ^= array[i];

        int index = findFirst1(bitResult);
        for (int i = 0; i < array.length; i++){
            if (isBit1(array[i], index))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    //从右往左寻找出第一个1
    private int findFirst1(int bitResult){
        int index = 0;          //从0开始计数，第一位做比较的时候不需要往右移
        while ((bitResult & 1) == 0 && index < 32){
            index++;
            bitResult >>= 1;
        }
        return index;
    }

    //判断是否同类
    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        new FindNumsAppearOnce().findNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5}, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }

}
