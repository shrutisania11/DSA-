class Solution {
    long LIMIT;

    // Computes nCr capped at LIMIT
    private long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);

        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans >= LIMIT) return LIMIT;
        }
        return ans;
    }

    // Number of distinct permutations of the multiset
    private long ways(int[] cnt) {
        int total = 0;
        for (int x : cnt) total += x;

        long ans = 1;
        int remaining = total;

        for (int x : cnt) {
            if (x == 0) continue;

            long c = comb(remaining, x);

            if (ans > LIMIT / c) return LIMIT;
            ans *= c;

            if (ans >= LIMIT) return LIMIT;

            remaining -= x;
        }

        return ans;
    }

    public String smallestPalindrome(String s, int k) {
        LIMIT = k;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] half = new int[26];
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }

        if (ways(half) < k) return "";

        StringBuilder left = new StringBuilder();

        int len = s.length() / 2;

        for (int pos = 0; pos < len; pos++) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) continue;

                half[c]--;

                long cnt = ways(half);

                if (cnt >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= cnt;
                    half[c]++;
                }
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        if (mid != 0) {
            return left.toString() + mid + right.toString();
        }

        return left.toString() + right.toString();
    }
}