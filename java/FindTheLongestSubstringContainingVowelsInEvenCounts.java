public class FindTheLongestSubstringContainingVowelsInEvenCounts {

    public int findTheLongestSubstring(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            String subS = s.substring(0, i + 1);
            int[] vowels = new int[26];
            for (int j = 0; j < subS.length(); j++) {
                vowels[subS.charAt(j) - 'a']++;
            }
            if (isVowel(vowels)) {
                result = subS.length();
                break;
            }
            for (int j = 1; j < s.length() - i; j++) {
                vowels[s.charAt(j - 1) - 'a']--;
                vowels[s.charAt(j + i) - 'a']++;
                if (isVowel(vowels)) {
                    result = subS.length();
                    break;
                }
            }
            if (result != 0) {
                break;
            }
        }
        return result;
    }

    private boolean isVowel(int[] vowels) {
        return vowels[0] % 2 == 0 && vowels[4] % 2 == 0 && vowels[8] % 2 == 0 && vowels[14] % 2 == 0 && vowels[20] % 2 == 0;
    }
}
