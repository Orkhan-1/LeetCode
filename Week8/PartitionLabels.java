class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int map [] = new int[26];
        for(int i = 0; i < S.length(); i++) {
            map[S.charAt(i)-'a'] = i;
        }
        int start = 0;
        while(start < S.length()){
            char begin = S.charAt(start);
            int end = map[begin - 'a'];
            for(int i = start; i < end; i++){
                int index = S.charAt(i) - 'a';
                if(map[index] > end) {
                    end = map[index];
                }
            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
}