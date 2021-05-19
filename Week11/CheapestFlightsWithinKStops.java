class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());   
        }
        for (int[] flight : flights){
            map.get(flight[0]).put(flight[1], flight[2]);
        } 
        Queue<int[]> pq = new PriorityQueue<>((a, b) ->a[0]-b[0]);
        pq.add(new int[] {0, src, -1});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int cost = temp[0];
            int ID = temp[1];
            int stop = temp[2];
            if (ID == dst) {
               return cost; 
            }
            if (stop < K) {
                Map<Integer, Integer> hs = map.getOrDefault(ID, new HashMap<>());
                for (int a : hs.keySet()) {
                    pq.add(new int[] {cost + hs.get(a), a, stop+1});
                }
            }
        }
        return -1;
    }
}