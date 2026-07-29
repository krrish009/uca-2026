public class ReversePair {
    
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }
    private int mergeSortAndCount(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSortAndCount(nums, left, mid);
        count += mergeSortAndCount(nums, mid + 1, right);

        count += mergeAndCount(nums, left, mid, right);

        return count;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2.0 * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        int[] temp = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, t = 0;

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[t++] = nums[p1++];
            } else {
                temp[t++] = nums[p2++];
            }
        }

        while (p1 <= mid) temp[t++] = nums[p1++];
        while (p2 <= right) temp[t++] = nums[p2++];

        System.arraycopy(temp, 0, nums, left, temp.length);
        return count;
    }

    public static void main(String[] args) {
        ReversePair arr = new ReversePair();
        int[] nums1 = {1, 3, 2, 3, 1};
        System.out.println(arr.reversePairs(nums1));
    }
}
