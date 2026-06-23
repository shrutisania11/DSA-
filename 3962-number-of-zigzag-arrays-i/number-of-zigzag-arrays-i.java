class Solution {

    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] dpUp = new long[m];
        long[] dpDown = new long[m];

        // Length = 2 initialization
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {

                if (a == b)
                    continue;

                if (b > a)
                    dpUp[b]++;

                else
                    dpDown[b]++;
            }
        }

        // Build lengths 3 to n
        for (int len = 3; len <= n; len++) {

            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            // Prefix sum of dpDown
            long[] prefix = new long[m];

            prefix[0] = dpDown[0];

            for (int i = 1; i < m; i++) {
                prefix[i] = (prefix[i - 1] + dpDown[i]) % MOD;
            }

            // nextUp[x] = sum(dpDown[k]) for k < x
            for (int x = 1; x < m; x++) {
                nextUp[x] = prefix[x - 1];
            }

            // Suffix sum of dpUp
            long[] suffix = new long[m];

            suffix[m - 1] = dpUp[m - 1];

            for (int i = m - 2; i >= 0; i--) {
                suffix[i] = (suffix[i + 1] + dpUp[i]) % MOD;
            }

            // nextDown[x] = sum(dpUp[k]) for k > x
            for (int x = 0; x < m - 1; x++) {
                nextDown[x] = suffix[x + 1];
            }

            dpUp = nextUp;
            dpDown = nextDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + dpUp[i] + dpDown[i]) % MOD;
        }

        return (int) ans;
    }
}