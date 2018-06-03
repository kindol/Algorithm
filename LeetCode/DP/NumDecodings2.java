package LeetCode.DP;

import java.util.Arrays;

/**
 * 解码方法 2：
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。
 *
 * 给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。
 *
 * 同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）
 *
 * 思路跟解码方法一样，只是需要考虑的情况多了
 */

public class NumDecodings2 {

    public int numDecodings(String s) {
        if (s.length() == 0 || s == null)
            return 0;

        final int mod = 1000000007;
        int n = s.length();
        int[] result = new int[n+1];
        Arrays.fill(result, 0);
        result[0] = 1;

        for (int i = 1; i <= n; i++){
            if (s.charAt(i-1) == '*'){
                result[i] = (int)((result[i] + 9L*result[i-1])%mod);
                if (i >= 2){
                    if (s.charAt(i-2) == '*')
                        result[i] = (int)((result[i] + 15l*result[i-1])%mod);
                    else if (s.charAt(i-2) == '1')
                        result[i] = (int)((result[i] + 9l*result[i-1])%mod);
                    else if (s.charAt(i-2) == '2')
                        result[i] = (int)((result[i] + 6l*result[i-1])%mod);
                }
            }else {
                if (s.charAt(i-1) != '0')
                    result[i] = (result[i] + result[i-1]) % mod;
                if (i >= 2){
                    if (s.charAt(i-2) == '*'){
                        if (s.charAt(i-1) <= '6')
                            result[i] = (int)((result[i] + 2l*result[i-2])%mod);
                        else
                            result[i] = (result[i] + result[i-2])%mod;
                    }else {
                        int twoDigits = (s.charAt(i-2)-'0')*10 + s.charAt(i-1)-'0';
                        if (twoDigits >= 10 && twoDigits <= 26)
                            result[i] = (result[i] + result[i-2])%mod;
                    }
                }
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings2().numDecodings("**"));
    }

}
