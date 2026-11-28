import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Use Integer.compare instead of subtraction to avoid 32-bit int overflow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // Balloon starts after current arrow; shoot a new arrow at this balloon's end
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}