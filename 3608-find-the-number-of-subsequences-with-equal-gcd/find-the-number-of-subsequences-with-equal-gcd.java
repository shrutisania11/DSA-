class Solution {

    static final int MOD = 1_000_000_007;

    Integer[][][] memo;

    public int subsequencePairCount(int[] nums) {

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        memo = new Integer[nums.length][max + 1][max + 1];

        return dfs(0, 0, 0, nums);
    }

    private int dfs(int idx, int g1, int g2, int[] nums) {

        if (idx == nums.length) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != null)
            return memo[idx][g1][g2];

        long ans = 0;

        // Ignore current element
        ans += dfs(idx + 1, g1, g2, nums);

        // Put into first subsequence
        int ng1 = (g1 == 0) ? nums[idx] : gcd(g1, nums[idx]);
        ans += dfs(idx + 1, ng1, g2, nums);

        // Put into second subsequence
        int ng2 = (g2 == 0) ? nums[idx] : gcd(g2, nums[idx]);
        ans += dfs(idx + 1, g1, ng2, nums);

        return memo[idx][g1][g2] = (int) (ans % MOD);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}