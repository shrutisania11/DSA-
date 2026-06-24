class Solution {

    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int d = r - l + 1;

        long[] vec = new long[2 * d];

        // Initial state for length = 2
        for (int i = 0; i < d - 1; i++) {
            vec[i] = 1;
        }

        for (int i = d + 1; i < 2 * d; i++) {
            vec[i] = 1;
        }

        long[][] mat = new long[2 * d][2 * d];

        for (int i = 0; i < d; i++) {

            // UP state
            for (int j = i + 1; j < d; j++) {
                mat[i][d + j] = 1;
            }

            // DOWN state
            for (int j = 0; j < i; j++) {
                mat[d + i][j] = 1;
            }
        }

        long[] ans = powerMultiply(mat, vec, n - 1);

        long res = 0;

        for (long x : ans) {
            res = (res + x) % MOD;
        }

        return (int) res;
    }

    private long[] powerMultiply(
            long[][] mat,
            long[] vec,
            int exp) {

        while (exp > 0) {

            if ((exp & 1) == 1) {
                vec = multiply(mat, vec);
            }

            mat = multiply(mat, mat);

            exp >>= 1;
        }

        return vec;
    }

    private long[][] multiply(
            long[][] a,
            long[][] b) {

        int n = a.length;

        long[][] c = new long[n][n];

        for (int i = 0; i < n; i++) {

            for (int k = 0; k < n; k++) {

                if (a[i][k] == 0) {
                    continue;
                }

                for (int j = 0; j < n; j++) {

                    if (b[k][j] == 0) {
                        continue;
                    }

                    c[i][j] =

                    (c[i][j]

                    + a[i][k]

                    * b[k][j])

                    % MOD;
                }
            }
        }

        return c;
    }

    private long[] multiply(
            long[][] mat,
            long[] vec) {

        int n = mat.length;

        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    continue;
                }

                ans[i] =

                (ans[i]

                + mat[i][j]

                * vec[j])

                % MOD;
            }
        }

        return ans;
    }
}