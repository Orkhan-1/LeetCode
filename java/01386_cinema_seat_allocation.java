class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }

        // Rows with no reservations
        int result = (n - map.size()) * 2;

        for (Set<Integer> reserved : map.values()) {

            boolean left =
                    !reserved.contains(2) &&
                            !reserved.contains(3) &&
                            !reserved.contains(4) &&
                            !reserved.contains(5);

            boolean middle =
                    !reserved.contains(4) &&
                            !reserved.contains(5) &&
                            !reserved.contains(6) &&
                            !reserved.contains(7);

            boolean right =
                    !reserved.contains(6) &&
                            !reserved.contains(7) &&
                            !reserved.contains(8) &&
                            !reserved.contains(9);

            if (left && right) {
                result += 2;
            } else if (left || middle || right) {
                result += 1;
            }
        }

        return result;
    }
}