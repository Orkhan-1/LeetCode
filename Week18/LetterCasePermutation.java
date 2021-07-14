import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if(S == null || S.isEmpty()) {
            return result;
        }
        bt(result, S.toCharArray(), 0);
        return result;
    }

    public void bt(List<String> result, char[] arr, int index) {
        result.add(new String(arr));
        for(int i = index; i<arr.length; i++) {
            char ch = arr[i];
            char temp = ch;

            if(ch >= 'a' && ch <= 'z') {
                arr[i] = Character.toUpperCase(ch);
                bt(result, arr, i + 1);
            } else if(ch >= 'A' && ch <= 'Z'){
                arr[i] = Character.toLowerCase(ch);
                bt(result, arr, i + 1);
            }
            arr[i] = temp;
        }
    }
}
