import java.util.Collections;
import java.util.PriorityQueue;

public class datastream {
    private PriorityQueue<Integer> lowerHalf; //Max-Heap
    private PriorityQueue<Integer> upperHalf; //Min-Heap

    public datastream() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }
    
    public void insert(int num) {
        lowerHalf.add(num);
        upperHalf.add(lowerHalf.poll());
        if (lowerHalf.size() < upperHalf.size()) {
            lowerHalf.add(upperHalf.poll());
        }
    }
    
    public float getMedian() {
        if (lowerHalf.size() > upperHalf.size()) {
            return (float) lowerHalf.peek();
        }
        return (float) (lowerHalf.peek() + upperHalf.peek()) / 2.0f;
    }
}
