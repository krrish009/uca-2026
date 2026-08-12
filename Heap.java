
import java.util.Arrays;

public class Heap {
    
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, n, arr);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0, i, arr);
        }
    }

    private void heapify(int i, int n, int[] arr) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(largest, n, arr);
        }
    }

    public static void main(String[] args) {
        Heap hs = new Heap();
        int[] data = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Original Array: " + Arrays.toString(data));
        hs.sort(data);
        System.out.println("Sorted Array:   " + Arrays.toString(data));
    }
}
