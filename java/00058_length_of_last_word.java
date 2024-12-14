//       Java
//  Time complexity - O (N)
// Space complexity - O (1)

// example 1: "The weather is rainy"
// example 2: "HelloWorld   "

class Solution {

    public int lengthOfLastWord(String s) {

        int size = 0;
        int start = s.length() - 1;

        while (s.charAt(start) == ' ') {
            start--;
        }

        while (start >= 0) {
            if (s.charAt(start) == ' ') {
                break;
            }
            start--;
            size++;
        }

        return size;
    }
}