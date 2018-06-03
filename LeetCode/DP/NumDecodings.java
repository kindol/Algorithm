package LeetCode.DP;

/**
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 思路：
 * 可以用递归做，那么肯定可以用动态规划做
 * 考虑从0到第i个数字共有的编码方法
 * 对于某一位i，若其不为‘0’,dp[i] = dp[i-1]，为0则先赋值为0，因为当第i为为0的时候不可以单独为自己
 * 如果与第i-1个数字可以组成其他数字，那么dp[i] = dp[i-2]
 */

public class NumDecodings {

    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0 || s.charAt(0) == '0')
            return 0;

        int[] res = new int[length+1];
        res[0] = 1;     //res[0]只是用于帮助res[2]的计算便于后面for循环的使用
        res[1] = 1;
        for (int i = 1; i < length; i++){
            res[i+1] = s.charAt(i) == '0' ? 0 : res[i];
            if (s.charAt(i-1) == '1' || s.charAt(i-1)=='2'&&s.charAt(i)<='6')
                res[i+1] += res[i-1];
        }
        return res[length];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("226"));
    }

}
