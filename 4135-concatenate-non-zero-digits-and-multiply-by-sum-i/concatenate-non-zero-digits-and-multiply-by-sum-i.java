class Solution {
    public long sumAndMultiply(int n) {

        String s = String.valueOf(n);

        long concat = 0;
        long sum = 0;

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            sum += digit;

            if (digit != 0) {
                concat = concat * 10 + digit;
            }
        }

        return concat * sum;
    }
}