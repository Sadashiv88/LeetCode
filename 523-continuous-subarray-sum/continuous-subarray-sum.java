import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Maps remainder -> earliest index where this remainder occurred
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1); // Handles valid subarrays starting at index 0

        long prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = (int) (prefixSum % k);

            if (remainderIndex.containsKey(remainder)) {
                if (i - remainderIndex.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Only store the first occurrence to maximize subarray length
                remainderIndex.put(remainder, i);
            }
        }

        return false;
    }
}