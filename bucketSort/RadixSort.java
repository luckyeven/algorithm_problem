import java.math.*;
import java.util.Arrays;

/**
 * this program use radix sort algorithm to sort an array of integers.
 * 
 * @author shifeng Song
 * @since 2022-May-15
 * @version 1.0
 */

public class RadixSort {

    /**
     * find the number of digits of the largest number in array.
     * 
     * @param arr an array
     * @return the number of digits
     */
    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }

        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void radixSort(int[] arr, int begin, int end) {
        if (arr == null || arr.length < 2) {
            return;
        }

        final int RADIX = 10;
        int numberOfDigits = maxBits(arr);

        int[] bucket = new int[end - begin + 1];

        int i, j = 0;
        for (int digit = 1; digit <= numberOfDigits; digit++) {
            int[] counter = new int[RADIX]; // [0,1,...,9]
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], digit);
                counter[j]++;
            }
            for (i = 1; i < RADIX; i++) {
                counter[i] = counter[i] + counter[i - 1];
            }
            for (i = end; i >= begin; i--) {
                j = getDigit(arr[i], digit);
                bucket[counter[j] - 1] = arr[i];
                counter[j]--;
            }

            for (i = begin, j = 0; i <= end; i++, j++) {
                arr[i] = bucket[j];
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = { 622, 363, 526, 331, 571, 480, 203, 639, 494, 684, 117, 971, 821, 31, 285, 789, 667, 694, 756, 565,
                408, 750, 796, 24, 59, 109, 684, 925, 539, 718, 524, 835, 463, 914, 779, 960, 305, 152, 597, 87, 852,
                711, 865, 593, 128, 99, 406, 368, 500, 572 };
        radixSort(arr, 0, 49);
        System.out.println(Arrays.toString(arr));
    }

}
