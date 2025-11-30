/*

Example 1:
arr = [5,5,4]
k = 1

Frequencies:
5 → 2
4 → 1

Remove least frequent → remove 4 (cost 1)
Remaining unique = {5}

Result = 1


=========================================================================
=========================================================================


Example 2:
arr = [4,3,1,1,3,3,2]
k = 3

Frequencies:

3 → 3
1 → 1

Sorted frequencies: [1,1,2,3]
Remove smallest first:
- remove freq=1 (4)
- remove freq=1 (2)
- remove one from freq=2

Remaining unique = {1,3}

Result = 2

*/

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort frequencies
        List<Integer> counts = new ArrayList<>(freq.values());
        Collections.sort(counts);

        // Step 3: Remove from smallest frequencies first
        int unique = counts.size();
        for (int c : counts) {
            if (k >= c) {
                k -= c;
                unique--; // completely removed one unique number
            } else {
                break;
            }
        }

        return unique;
    }
}
