//            Java
//     Time complexity - O (N)
//     Space complexity - O (1)
public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        int openParentheses = 0;
        int minAdd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParentheses++;
            } else if (s.charAt(i) == ')') {
                if (openParentheses == 0) {
                    minAdd++;
                } else {
                    openParentheses--;
                }
            }
        }
        return minAdd + openParentheses;
    }
}
