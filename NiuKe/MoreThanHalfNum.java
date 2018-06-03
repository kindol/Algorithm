package NiuKe;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * 思路：
 * 由于是大于数组的长度，好比如上数组长度为9，那么至少数字重复5次，意味着其他数字归为一类
 * 采用阵地攻防的思路
 * 第一个数字作为第一个士兵，守阵地；count = 1；
 * 碰到同个数字，+1
 * 否则，为敌人，-1,（如果当前数字是答案，那么应该会保留到最后，因为重复的次数大于其他所有数字之和）
 * 当count=0时，使用当前数字替换
 * 当然，一次遍历下来可能留下来的不是主元素（不存在主元素的情况下），所以要再加一次循环确认
 */

public class MoreThanHalfNum
{
    public int MoreThanHalfNum_Solution(int [] array)
    {
        if (array == null || array.length == 0)
            return 0;
        int num = array[0];
        int count = 1;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == num)
                count++;
            else
                count--;
            if (count == 0)
            {
                num = array[i];
                count = 1;
            }
        }

        //verify
        count = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == num)
                count++;

        if (count > array.length/2)
            return num;
        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }

}
