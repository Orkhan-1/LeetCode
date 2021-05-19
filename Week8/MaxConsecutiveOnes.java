class MaxConsecutiveOnes {
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int j = 0;
        while (j < A.length) {
            if (A[j++] == 0) {
              K--;  
            }
            if (K < 0 && A[i++] == 0) {
              K++;  
            }
        }
        return j - i;
    }
}