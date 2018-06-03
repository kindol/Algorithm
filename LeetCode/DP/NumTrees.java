package LeetCode.DP;

import java.util.Arrays;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 思路：
 * 有n个节点，假设左边有0、1、2、...、n/2个节点，
 * n为奇数则左右各半为偶数，n为偶数则左右有一方为奇数
 * 考虑DP
 * 那么左边的种数*右边的种数=总的种数
 * dp[i] += dp[k]*dp[i-k-1]（只有数目关系，由于是二叉树，所以根节点在每次k确定的时候都是确定的，因为要左小右大）
 */

public class NumTrees {

    public int numTrees(int n) {
        if (n <= 1)
            return 1;
        int[] res = new int[n+1];
        Arrays.fill(res, 0);
        res[0] = res[1] = 1;

        for (int i = 2; i <= n; i++)
            for (int k = 0; k <= i-1; k++)
                res[i] += res[k]*res[i-k-1];

        return res[n];
    }

}
