/**
 * Given an array arr[0 .. n-1] of distinct integers, the task is to find a
 * local minima in it.
 * We say that an element arr[x] is a local minimum if it is less than both its
 * neighbors.
 * for corner elements, we need to consider only one neighbor for comparison.
 * There can be more than one local minima in an array, we need to find one of
 * them.
 * 
 * Requirement: time complex O(logN)
 * 
 * Examples:
 * 
 * Input: arr[] = {9, 6, 3, 14, 5, 7, 4};
 * Output: Index of local minima is 2
 * The output prints index of 3 because it is
 * smaller than both of its neighbors.
 * Note that indexes of elements 5 and 4 are
 * also valid outputs.
 * 
 * Input: arr[] = {23, 8, 15, 2, 3};
 * Output: Index of local minima is 1
 * 
 * Input: arr[] = {1, 2, 3};
 * Output: Index of local minima is 0
 * 
 * Input: arr[] = {3, 2, 1};
 * Output: Index of local minima is 2
 * 
 * @author Shifeng Song @luckyeven
 * @since 2022-05-06
 * @version 2.0
 * 
 */

public class LocalMin {

    static final int MINIMUM_LENGTH_OF_ARRAY = 3;

    public static int findLocalMin(int[] arr, int first, int last) {
        int mid = first + (last - first) >> 1;

        if (mid == 0) {
            return mid;
        }

        if (last - first < MINIMUM_LENGTH_OF_ARRAY) {
            if (arr[first] < arr[first + 1]) {
                return first;
            }
            if (arr[last] < arr[last - 1]) {
                return last;
            }
        }

        if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
            return mid;
        } else if (arr[mid] < arr[mid - 1]) {
            return findLocalMin(arr, mid + 1, last);
        }
        return findLocalMin(arr, first, mid + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 9, 6, 3, 14, 5, 7, 4 };
        int i = findLocalMin(arr, 0, arr.length - 1);
        System.out.println("Index of local minima is " + i);
    }

}
