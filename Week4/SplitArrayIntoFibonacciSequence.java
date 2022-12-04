import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, result, 0);
        return result;
    }

    private boolean backtrack(String s, List<Integer> result , int index) {
        if(s.length() == index) {
            return result.size() > 2;
        }

        int num = 0;
        for(int i = index; i < s.length(); i++){
            num = (num * 10) + (s.charAt(i) - '0');
            if(num < 0) {
                return false;
            }
            if(result.size() < 2 || (result.get(result.size() -1) + result.get(result.size()-2) == num)) {
                result.add(num);
                if(backtrack(s,result, i+1)) {
                    return true;
                }
                result.remove(result.size()-1);
            }
            if(i == index && s.charAt(i) == '0') {
                return false;
            }
        }
        return false;
    }
}
