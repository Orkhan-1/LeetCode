import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximizeSumOfArrayAfterKNegations {

    public int largestSumAfterKNegations(int[] A, int K) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(int a: A){
            minHeap.add(a);
        }

        for(int i=0 ; i<K ; ++i){
            int curr = minHeap.poll();
            minHeap.add(-1*curr);
        }

        int result = 0;
        while(!minHeap.isEmpty()){
            result += minHeap.poll();
        }

        return result;
    }
}
