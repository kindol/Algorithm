package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 假设每个输入只对应一种答案，且同样的元素不能被重复利用
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 思路1：
 * 先对数组排序（需要自己建立新的节点），使用两个指针，一个从头开始，一个从尾巴开始，
 * 头部和尾部相加如果大了，将尾巴往左移；否则，将头部往右移
 *
 * 思路2：
 * 使用hash算法（在这里使用map，但本质一样）
 * 每个key为对应的nums[i]，而value为对应的下标
 */

public class TwoSum {

    class Node implements Comparable{
        public int num;
        public int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            if (num < ((Node)o).num)
                return -1;
            else if (num == ((Node)o).num)
                return 0;
            else
                return 1;
        }
    }

    public int[] twoSum1(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        int total = 0;

        Node[] nodes = new Node[nums.length];
        for (int cnt = 0; cnt < nodes.length; cnt++)
            nodes[cnt] = new Node(nums[cnt], cnt);

        Arrays.sort(nodes);
        while (i < j){
            total = nodes[i].num + nodes[j].num;
            if (target == total){
                int a = nodes[i].index;
                int b = nodes[j].index;
                if (a > b)
                    return new int[]{b, a};
                else
                    return new int[]{a, b};
            }

            else if (target > total)
                i++;
            else
                j--;
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
                int index = map.get(target-nums[i]);
                if (i < index)
                    return new int[]{i ,index};
                else
                    return new int[]{index, i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }

}
