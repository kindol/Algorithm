package LeetCode.DP;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 思路：
 * 对于点（i，j）只有两种方式可以到达，从上方或者从左方
 * 先判断当前位置否是为又障碍物，有则设置为0
 * 再需要判断是否为边界，是的话直接赋值为1，因为前面已经检查过是否为障碍物，所以这里不需要检查
 * 否则为动态规划定理——dp[i][j] = dp[i-1][j] + dp[i][j-1];
 */

public class UniquePathWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] results = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    results[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    results[i][j] = 1;
                } else if (i == 0) {
                    //单只有一行则依赖前者
                    results[i][j] = results[i][j - 1];
                } else if (j == 0) {
                    //单只有一列则依赖上者
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = results[i - 1][j] + results[i][j - 1];
                }
            }
        }

        return results[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
