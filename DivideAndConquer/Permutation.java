package DivideAndConquer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：
 * 需要注意重复字符串的情况
 *
 * 递归，每一层进行将首字符与后面每一个非相同字符进行交换再往深层递归
 */

public class Permutation
{

    public static void swap(char[] src, int i, int j)
    {
        char tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }

    public ArrayList<String> Permutation(String str)
    {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0)
            return result;

        permutateHelp(str.toCharArray(), result, 0);
        Collections.sort(result);
        return result;
    }

    public void permutateHelp(char[] str, ArrayList<String> res, int begin)         //begin代表当前层对应的头结点
    {
        if (begin == str.length-1)
        {
            res.add(new String(str));
            return;
        }

        for (int i = begin; i < str.length; i++)            //依次交换字符
        {
            if (i != begin && str[i] == str[begin])         //判断是否重复
                continue;
            swap(str, i, begin);
            permutateHelp(str, res, begin+1);
            swap(str, i, begin);                            //记得换回来
        }
    }

}
