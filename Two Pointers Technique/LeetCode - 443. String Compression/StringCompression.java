//     Java
// Time complexity - O(N)
// Space complexity - O(1)

public class StringCompression {

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int index = 0;
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            chars[index++] = currentChar;

            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }

}
