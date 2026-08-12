
import java.util.PriorityQueue;

public class village {
      public static float minLoad(int pop[], int n, int k) {
        PriorityQueue<float[]> pq = new PriorityQueue<>((a,b) ->Float.compare(b[0], a[0]));
        for (int i = 0; i < n; i++){
            pq.add(new float[]{pop[i], pop[i], 1});
        }
        int remaining = k - n;

        while (remaining-- > 0) {
            float[] top = pq.poll();
            float load = top[0];
            float population = top[1];
            float hospitals = top[2];  
            hospitals++;

            float newLoad = population / hospitals;
            pq.add(new float[]{newLoad, population, hospitals});
        }
        return pq.peek()[0];
    }

    public static void main(String[] args) {
        int pop[] = {200, 20, 50};
        System.out.println(minLoad(pop, 3, 5));
    }
}