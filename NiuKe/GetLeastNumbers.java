package NiuKe;

import java.util.*;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 思路1：
 * 插入排序的思想，只需要选取前K小个即可
 *
 * 思路2：
 * 使用最大堆（不是最小堆！），
 * 不断插入直到堆大小有K个节点之后，
 * 每次插入都判断是否大于头结点，是则替换，否则跳过
 */

public class GetLeastNumbers
{

    private void swap(int[] input, int l, int r)
    {
        if (l == r)
            return;
        input[l] = input[l] ^ input[r];
        input[r] = input[l] ^ input[r];
        input[l] = input[l] ^ input[r];
    }

    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length)
            return res;
        for (int i = 0; i < k; i++)
        {
            for (int j = i+1; j < input.length; j++)
                if (input[i] > input[j])
                    swap(input, i, j);
            res.add(input[i]);
        }

        return res;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k > input.length)
            return result;

        //设置大顶堆，默认为小顶堆
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < k; i++)
            queue.add(input[i]);

        for (int i = k; i < input.length; i++)
            if (input[i] < queue.peek())
            {
                queue.remove();                 // 删除栈顶
                queue.add(input[i]);
            };

        while (!queue.isEmpty())
            result.add(queue.remove());

        return result;
    }

    public static void main(String[] args)
    {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        new GetLeastNumbers().GetLeastNumbers_Solution1(input, 4);
        System.out.println(Arrays.toString(input));
    }
}
