class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Count frequency of each card
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {

            // Get the smallest available number
            int first = map.firstKey();

            // Form a consecutive group
            for (int i = 0; i < groupSize; i++) {

                int num = first + i;

                if (!map.containsKey(num)) {
                    return false;
                }

                int count = map.get(num);

                if (count == 1) {
                    map.remove(num);
                } else {
                    map.put(num, count - 1);
                }
            }
        }

        return true;
    }
}
