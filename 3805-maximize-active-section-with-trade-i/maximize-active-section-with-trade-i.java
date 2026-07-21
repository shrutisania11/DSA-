class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";
        int n = t.length();

        List<Character> type = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        for (int i = 0; i < n; ) {
            char ch = t.charAt(i);
            int j = i;
            while (j < n && t.charAt(j) == ch) j++;

            type.add(ch);
            len.add(j - i);

            i = j;
        }

        int bestGain = 0;

        for (int i = 1; i < type.size() - 1; i++) {

            if (type.get(i) == '1'
                && type.get(i - 1) == '0'
                && type.get(i + 1) == '0') {

                bestGain = Math.max(bestGain,
                        len.get(i - 1) + len.get(i + 1));
            }
        }

        return ones + bestGain;
    }
}