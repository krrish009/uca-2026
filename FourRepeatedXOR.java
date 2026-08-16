public class FourRepeatedXOR {
    public static int findFourRepeated(int[] arr) {
        int ones = 0;
        int twos = 0;

        for (int num : arr) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 4, 1, 2, 3, 4, 3, 3};
        int ans = findFourRepeated(arr);
        System.out.println(ans);
    }
}
