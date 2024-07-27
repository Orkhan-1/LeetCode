import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class NumberOfMatchingSubsequences {

    private Map<Character, TreeSet<Integer>> map = new HashMap<>();

    public int numMatchingSubseq(String s, String[] words) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                TreeSet<Integer> set = map.get(c);
                set.add(i);
                map.put(c, set);
            } else {
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(i);
                map.put(c, treeSet);
            }
        }
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word)) {
                count++;
            }
        }
        return count;
    }

    public boolean isSubsequence(String s) {
        int index = -1;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            SortedSet<Integer> set = map.get(c).tailSet(index + 1);
            if (set.isEmpty()) {
                return false;
            }
            index = set.first();
        }
        return true;
    }

}
