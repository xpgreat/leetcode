package problem62;

/**
 * @Author xp
 * @Date：2019-02-27
 */
public class Solution {

    /**
     * 题目描述：Unique Paths
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down
     * 2. Right -> Down -> Right
     * 3. Down -> Right -> Right
     * 思路：f(m,n)=f(n-1,m)+f(n,m-1)
     * 1. 递归
     * 2. 动态规划
     * 3. 优化dp
     */

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (i==m-1||j==n-1){
                    dp[i][j]=1;
                }else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static int uniquePathsDiGui(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        } else {
            return uniquePathsDiGui(m - 1, n) + uniquePathsDiGui(m, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));;
    }

}
