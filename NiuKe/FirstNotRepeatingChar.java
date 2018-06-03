package NiuKe;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 *
 * 思路：
 * 使用map构建，后面再用str每个字符遍历一次
 * 本质上，其实使用的是hash表，不过可能会有str为空、str中字母大小写的问题
 */

public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str) {

        Map<Character, Integer> auxiliary = new HashMap<>();

        for (Character ch: str.toCharArray())
        {
            if (auxiliary.containsKey(ch))
                auxiliary.put(ch, auxiliary.get(ch)+1);
            else
                auxiliary.put(ch, 1);
        }

        for (int i = 0; i < str.length(); i++)
            if (auxiliary.get(str.charAt(i)) == 1)
                return i;

        return -1;          //不存在的情况
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().firstNotRepeatingChar(""));

        System.out.println(new FirstNotRepeatingChar().firstNotRepeatingChar("jfieaegezge"));
    }

}
