
class Solution {
    public int minGroupsForValidAssignment(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE;

        for (int freq : map.values()) {
            minFreq = Math.min(minFreq, freq);
        }

        for (int k = minFreq; k >= 1; k--) {

            int groups = 0;
            boolean possible = true;

            for (int freq : map.values()) {

                int count = freq / (k + 1);
                int rem = freq % (k + 1);

                if (rem == 0) {
                    groups += count;
                }
                else if (rem + count >= k) {
                    groups += count + 1;
                }
                else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                return groups;
            }
        }

        return 0;
    }
}
