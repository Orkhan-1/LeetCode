import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String current = new String(c);
            if (map.containsKey(current)) {
                map.get(current).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(current, list);
            }
        }

        for (String s : map.keySet()) {
            result.add(map.get(s));
        }

        return result;
    }
}
