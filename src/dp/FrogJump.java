package dp;

public class FrogJump {

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int first = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int second = 9999;
            if (i > 1) {
                second = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(first, second);
        }
        return dp[n - 1];
    }

    static int jump(int n, int[] heights, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int left = jump(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = 99999;
        if (n > 1) {
            right = jump(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }
        return dp[n] = Math.min(left, right);
    }
}
