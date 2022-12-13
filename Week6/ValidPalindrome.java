public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (!Character.isLetterOrDigit(s.charAt(begin))) {
                begin++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(begin)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
