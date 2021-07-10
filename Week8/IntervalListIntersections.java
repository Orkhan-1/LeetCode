import java.util.ArrayList;
import java.util.List;

class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int f = 0;
        int s = 0;
        List<int[]> list = new ArrayList<>();
        
        while (f < firstList.length && s < secondList.length) {
             int begin = Math.max(firstList[f][0], secondList[s][0]);
             int end = Math.min(firstList[f][1], secondList[s][1]);
            
            if (begin <= end) {
                list.add(new int[]{begin, end});
            }
            
            if (end >= firstList[f][1]) {
                f++;
            }
            
            if (end >= secondList[s][1]) {
                s++;
            }
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}