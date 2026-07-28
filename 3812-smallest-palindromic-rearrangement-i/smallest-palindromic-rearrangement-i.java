class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char mid = '\0';

        // Build the left half and find the middle character
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if (freq[i] % 2 == 1) {
                mid = (char) ('a' + i);
            }
        }

        // Right half is reverse of left half
        String right = new StringBuilder(left).reverse().toString();

        // Return the final palindrome
        if (mid != '\0') {
            return left.toString() + mid + right;
        }

        return left.toString() + right;
    }
}