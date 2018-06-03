package LeetCode.DP;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 思路：
 * 可以是递归也可以是动态规划
 * 以动态规划的方式，也就是最终只能从上或者左边到达
 * 因而，公式为
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 需要注意的是对数组的初始化是对第二行和第二列赋值为1
 */
public class UniquePaths {

    //m为列数，n为行数
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[n+1][m+1];
        Arrays.fill(arr[1], 1);

        for (int i = 1; i <= n; i++){
            arr[i][1] = 1;
            for (int j = 1; j <= m; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3,2));

    }

}
