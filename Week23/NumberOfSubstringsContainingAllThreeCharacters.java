/*
 *  Explanation:
 * -Two pointers technique is used; we create 2 pointers i and j
 * -e.g. 'aaabca'
 * -Move j until there is at least one of each letter 'abc'. In this case it is at index=4 i.e. 'aaabc'
 * -From index=4 to the end of the String all substrings contain at least one abc e.g. 'aaabc', 'aaabca'; result+=size-j
 * -Also from beginning of the String all substrings will have size-j substring containing at least one 'abc' e.g. 'aabc' and 'aabca'
 * -Move i pointer until we have at least one 'abc' and increment result+=size+j; Then repeat until i<j
 * */

public class NumberOfSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int result = 0;
        int i = 0;
        int j = 0;
        int size = s.length();
        while (j < size) {
            count[s.charAt(j) - 'a']++;
            while (i < j && count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += (size - j);
                count[s.charAt(i++) - 'a']--;
            }
            j++;
        }
        return result;
    }
}
