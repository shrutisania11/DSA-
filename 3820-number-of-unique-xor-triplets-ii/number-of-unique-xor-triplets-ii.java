class Solution {
    public int uniqueXorTriplets(int[] nums) {

        boolean[] present = new boolean[2048];

        for (int x : nums) {
            present[x] = true;
        }

        boolean[][] dp = new boolean[4][2048];
        dp[0][0] = true;

        for (int pick = 1; pick <= 3; pick++) {

            for (int xor = 0; xor < 2048; xor++) {

                if (!dp[pick - 1][xor])
                    continue;

                for (int value = 0; value < 2048; value++) {

                    if (present[value]) {
                        dp[pick][xor ^ value] = true;
                    }
                }
            }
        }

        int ans = 0;

        for (boolean possible : dp[3]) {
            if (possible)
                ans++;
        }

        return ans;
    }
}