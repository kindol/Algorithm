package LeetCode.DP;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 *
 * 思路1：
 * 动态规划，因为如果当前子串s[j, i]为回文串，那么s[j+1, i-1]肯定为回文串，
 * 而对于某一位s[i]，那么其自身可以为回文（只有一个）
 * 所以有如下公式：
 *           true                           i = j（只有一个）
 * f(j, i) = s[i]=s[j]                      i = j+1（相邻且相等）
 *           s[j]=s[j] && f(j+1, i-1)       i > j+1（i与j不相邻）
 *
 * 思路2：
 * 从头遍历到尾，当前位置为i，
 * 假设为奇数串，那么当前位直接作回文串中间，往周边拓展
 * 假设为偶数串，那么当前位与后面一位作为回文串中间，再往周边拓展
 */

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i = 0; i < f.length; i++)
            for (int j = 0; j < f.length; j++)
                f[i][j] = false;

        int maxLength = 1;
        int start = 0;
        //i表示从第0位到当前第i位，j为i前面的某位
        for (int i = 0; i < s.length(); i++){
            f[i][i] = true;
            for (int j = 0; j < i; j++){
                f[j][i] = (s.charAt(i) == s.charAt(j)) && (i == j+1 || f[j+1][i-1]);
                if (f[j][i] && maxLength < (i-j+1)){
                    maxLength = i-j+1;
                    start = j;
                }
            }
        }

        f = null;
        return s.substring(start, start+maxLength);
    }

    private int start = 0;
    private int maxLength = 1;
    public String longestPalindrome2(String s){
        if (s.length() < 2)
            return s;

        for (int i = 0; i < s.length(); i++){
            getMaxLength(s, i, i);
            getMaxLength(s, i, i+1);
        }
        return s.substring(start, start+maxLength);
    }

    private void getMaxLength(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if (maxLength < (j-i+1)){
                maxLength = j-i+1;
                start = i;
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }

}
