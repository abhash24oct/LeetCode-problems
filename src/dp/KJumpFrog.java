package dp;

import java.util.Arrays;

public class KJumpFrog {

    public static int frogJump(int n, int heights[], int k) {
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return solve(n-1,  heights, dp, k);
    }

    static int solve(int index, int[] heights, int[] dp, int k) {
        if(index == 0 ){
            return 0;
        }
        if(dp[index] != -1){
            return  dp[index];
        }
        int minJump = Integer.MAX_VALUE;
        for (int j = 1; j <=k ; j++) {
            if(index - j >0) {
                int jump =
                        dp[index - j] + Math.abs(heights[index] - heights[index - j]);
                minJump = Math.min(jump, minJump);
            }
        }
        return  dp[index] = minJump;
    }
}
