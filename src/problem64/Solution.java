package problem64;

/**
 * @Author xp
 * @Date：2019-02-28
 */
public class Solution {
    /**
     * 题目描述：Unique Paths II
     * Input:
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * Output: 2
     * Explanation:
     * There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     * 思路：f(m,n)=f(n-1,m)+f(n,m-1)
     * 1. 递归
     * 2. 动态规划
     * 3. 优化dp
     */
    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] += grid[i][j];
                } else if (i == m - 1) {
                    dp[i][j] += dp[i][j + 1]+grid[i][j];
                } else if (j == n - 1) {
                    dp[i][j] += dp[i + 1][j]+grid[i][j];
                } else {
                    dp[i][j] += grid[i][j]+(dp[i + 1][j] < dp[i][j + 1] ? dp[i + 1][j] : dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int a[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int k = uniquePathsWithObstacles(a);
        System.out.println(k);
    }

    public int getMinSum(int[][] obstacleGrid, int m, int n) {
        /*int[][] dp = new int[m][n];
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (i==m-1){
                    dp[i][j]+=dp[i][j+1];
                }
                else if (j==n-1){
                    dp[i][j]+=dp[i+1][j];
                }
                else {
                    dp[i][j]+=dp[i+1][j]>dp[i][j+1]?dp[i+1][j]:dp[i][j+1];
                }
            }
        }
        return dp[0][0];*/
        return 0;
    }
}
