class Solution {

    private int calc(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int firstEnd = Integer.MAX_VALUE;

        // Earliest finish time of the first ride
        for (int i = 0; i < start1.length; i++) {
            firstEnd = Math.min(firstEnd, start1[i] + duration1[i]);
        }

        int ans = Integer.MAX_VALUE;

        // Try every second ride
        for (int i = 0; i < start2.length; i++) {
            ans = Math.min(ans, Math.max(firstEnd, start2[i]) + duration2[i]);
        }

        return ans;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int landFirst = calc(landStartTime, landDuration,
                             waterStartTime, waterDuration);

        int waterFirst = calc(waterStartTime, waterDuration,
                              landStartTime, landDuration);

        return Math.min(landFirst, waterFirst);
    }
}