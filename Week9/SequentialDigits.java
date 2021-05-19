class SequentialDigits {
   public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();
        
        for (int i = 1; i <= 9; ++i) {
            bt(result, 0, i, low, high);
        }
       
        Collections.sort(result);
        return result;
    }
    
    private void bt(List<Integer> result, int cur, int n, int low, int high) {
        if (cur >= low && cur <= high) {
            result.add(cur);
        } 
        if (cur > high || n > 9) {
            return;
        }
        bt(result, cur * 10 + n, n + 1, low, high);
    }
}