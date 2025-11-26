/*

Example 1:
houses  = [1, 4, 8]
heaters = [2, 10]


          1    2    4       8        10
Houses    🏠        🏠      🏠
Heaters        🔥                    🔥

Minimum required radius = 2

=========================================================================
=========================================================================

Example 2:
houses = [1, 2, 3, 5, 15]
heaters = [2, 30]

          1   2   3       5                     15                   30
Houses    🏠  🏠  🏠       🏠                     🏠
Heaters       🔥                                                      🔥

Minimum required radius = 13

*/


public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> sortedHeaters = new TreeSet<>();
        for (int h : heaters) {
            sortedHeaters.add(h);
        }

        int maxRadius = 0;

        for (int house : houses) {
            Integer floor = sortedHeaters.floor(house);
            Integer ceiling = sortedHeaters.ceiling(house);

            int leftDist = floor == null ? Integer.MAX_VALUE : house - floor;
            int rightDist = ceiling == null ? Integer.MAX_VALUE : ceiling - house;

            int radius = Math.min(leftDist, rightDist);
            maxRadius = Math.max(maxRadius, radius);
        }

        return maxRadius;
    }
}
