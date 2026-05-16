class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] <= prev[1])
                prev[1] = Math.max(prev[1], interval[1]);
            else {
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[0][]);
    }
}