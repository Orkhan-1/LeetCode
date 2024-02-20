
// Time complexity - O (N)
// Space complexity - O (1)
public class ValidPalindromeTwo {


    // aabcbaa
    public static boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private static boolean isPalindrome(String input, int s, int e) {
        while (s < e) {
            if (input.charAt(s) != input.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

}
