import java.util.HashMap;
import java.util.Map;

// Time complexity - O(N + M)
// Space complexity - O(M)
public class CustomSortString {
    public String customSortString(String order, String s) {
        String result = "";
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (chars.get(s.charAt(i)) == null) {
                chars.put(s.charAt(i), 1);
            } else {
                chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < order.length(); i++) {
            if (chars.get(order.charAt(i)) != null) {
                int size = chars.get(order.charAt(i));
                while (size != 0) {
                    result = result + order.charAt(i);
                    size--;
                }
                chars.remove(order.charAt(i));
            }
        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            int size = entry.getValue();
            while (size != 0) {
                result = result + entry.getKey();
                size--;
            }
        }
        return result;
    }
}
