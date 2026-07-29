import java.util.ArrayList;
import java.util.List;

public class CountSmallerAfterSelf {

    private static class Node {
        int val;
        int id;
        Node(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        int n = nums.length;
        int[] count = new int[n];
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(nums[i], i);
        }
        mergeSortAndCount(arr, 0, n - 1, count);
        for (int c : count) {
            ans.add(c);
        }
        return ans;
    }

    private static void mergeSortAndCount(Node[] arr, int left, int right, int[] count) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSortAndCount(arr, left, mid, count);
        mergeSortAndCount(arr, mid + 1, right, count);
        merge(arr, left, mid, right, count);
    }

    private static void merge(Node[] arr, int left, int mid, int right, int[] count) {
        Node[] temp = new Node[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int rightSmallerCount = 0;
        while (i <= mid && j <= right) {
            if (arr[j].val < arr[i].val) {
                rightSmallerCount++;
                temp[k++] = arr[j++];
            } else {
                count[arr[i].id] += rightSmallerCount;
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            count[arr[i].id] += rightSmallerCount;
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }
}
