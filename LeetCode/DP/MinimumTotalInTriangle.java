package LeetCode.DP;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 思路：
 * 动态规划
 * f(i,j) = min{f(i + 1,j),f(i + 1,j + 1)} + (i,j)
 *
 * 一个细节：为了使得只有n的空间复杂度，倒着从低往上计算
 */

public class MinimumTotalInTriangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int[] res = new int[triangle.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = triangle.get(triangle.size()-1).get(i);

        //从倒数第二个开始计算、也是从倒数第二行开始计算
        for (int i = triangle.size()-2; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                int min = res[j] < res[j+1] ? res[j] : res[j+1];
                res[j] = min + triangle.get(i).get(j);
            }
        }

        return res[0];
    }

}
