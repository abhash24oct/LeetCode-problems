package dp;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) arr1[i - 1] = nums[i];
            if (i != nums.length - 1) arr2[i] = nums[i];
        }

        return Math.max(solve(arr1), solve(arr2));
    }

    int solve(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i-1]);
        }
        return dp[arr.length - 1];
    }
}
