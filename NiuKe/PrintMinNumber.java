package NiuKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：
 * 因为每个数都不能拆分，所以只要前面的是小的，该数就是最小的，所以要排序
 * 排序过程中，由于是直接数字组合，所以要变成String，
 * 而且，真正的比较对象应该是两个字符串加起来再反序加起来后的比较
 * 求最大的一个也是同理
 * 
 * 如果是没有进行字符串相加而是直接比较字符串，那么会有如下反例：
 * 9 91
 * 正确答案是919
 * 而如果是直接比较字符串，那么会得到答案991，反而大了
 */

public class PrintMinNumber {

    public String printMinNumber(int [] numbers) {
        StringBuilder res = new StringBuilder();

        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            tmp.add(numbers[i]);
        }

        Collections.sort(tmp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString() + o2.toString();
                String s2 = o2.toString() + o1.toString();
                return s1.compareTo(s2);
            }
        });

        for (int j : tmp)
            res.append(j);

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PrintMinNumber().printMinNumber(new int[]{3,32,321}));
    }

}
