package dp;

public class UniquePathGrid {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(i==m-1 && j==n-1){
                        dp[i][j] = 1;
                    } else{
                        int right=0;
                        int down =0;
                        if(i < m-1){
                            down = dp[i+1][j];
                        }
                        if(j < n-1){
                            right = dp[i][j+1];
                        }
                        dp[i][j] = right + down;
                    }
                }
            }
            return dp[0][0];
        }

        //call with 0 0
        int solve(int m, int n ,int i, int j ,int[][]dp){
            if(i == m-1 && j == n-1 ){
                return 1;
            }
            if(i > m-1 || j > n-1){
                return 0;
            }
            if(dp[i][j] != -1){
                return dp[i][j];
            }
            int right = solve(m ,n, i, j+1, dp);
            int down = solve(m, n, i+1, j, dp);;
            return dp[i][j] = right + down;
        }
    }
}
