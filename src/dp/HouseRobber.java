package dp;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solveUsingMemoization(nums, nums.length - 1, dp);
    }

    int solveUsingTabulation(int[] nums, int[] dp) {
        dp[0] = nums[0];
        if (nums.length == 1) {
            return nums[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    int solveUsingTabulationWithSpaceOptimization(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        int prev2 = nums[0];
        int prev1 = Math.max(prev2,nums[1]);
        int curr;

        for(int i=2 ;i< nums.length ;i++){
            curr = Math.max(nums[i]+prev2 , prev1);
            prev2 = prev1;
            prev1 = curr;

        }
        return prev1;
    }


    int solveUsingMemoization(int[] nums, int index, int[] dp) {

        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + solveUsingMemoization(nums, index - 2, dp);
        int nonPick = solveUsingMemoization(nums, index - 1, dp);
        return dp[index] = Math.max(pick, nonPick);
    }
}

