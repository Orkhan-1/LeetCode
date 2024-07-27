import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for (int i = 0; i < strs.length; i++) {
            String original = strs[i];
            char[] chars = original.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) {
                List<String> list = map.get(sorted);
                list.add(original);
                map.put(sorted, list);
            } else {
                map.put(sorted, new ArrayList<>(List.of(original)));
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
