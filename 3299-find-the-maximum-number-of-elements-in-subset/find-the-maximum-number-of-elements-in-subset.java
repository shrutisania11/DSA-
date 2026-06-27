class Solution {

    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put((long)x, map.getOrDefault((long)x, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (map.containsKey(1L)) {
            int cnt = map.get(1L);

            if (cnt % 2 == 0)
                ans = Math.max(ans, cnt - 1);
            else
                ans = Math.max(ans, cnt);
        }

        for (long num : map.keySet()) {

            if (num == 1)
                continue;

            long curr = num;

            int length = 0;

            while (map.getOrDefault(curr, 0) >= 2) {

                length += 2;

                if (curr > 1000000000L)
                    break;

                curr = curr * curr;
            }

            if (map.getOrDefault(curr, 0) >= 1)
                length++;

            else
                length--;

            ans = Math.max(ans, length);
        }

        return ans;
    }
}