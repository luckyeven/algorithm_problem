import java.util.Arrays;
import java.math.*;

/**
 * @author Shifeng Song
 * @since May 12, 2022
 * @version 1.0
 * 
 *          KsortedArraySort program will sort a given array that is almost
 *          sorted .
 *          use small pile heap sort, Time complex is O(NlogK)
 */

public class KsortedArraySort {

    public static void heapSort(int[] arr, int k) {
        if (arr == null) {
            return;
        }
        int index = 0;
        int[] heap = new int[k + 1];
        int heapSize = k;

        for (; index <= Math.min(arr.length, k); index++) {
            heapInsert(heap, index, arr[index]);

        }
        int i = 0;
        for (; index < arr.length; index++, i++) {
            arr[i] = pop(heap, heapSize);
            heapInsert(heap, heap.length - 1, arr[index]);
        }

        for (; i < arr.length; i++) {
            arr[i] = pop(heap, heapSize--);
        }

    }

    // make a small pile heap
    public static void heapInsert(int[] arr, int index, int item) {
        arr[index] = item;
        while (arr[index] < arr[(index - 1) / 2]) {
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    // heapify the array starting at index
    public static void heapify(int[] arr, int index, int heapSize) {
        int leftLeaf = (index >> 1) + 1;
        while (leftLeaf < heapSize) {
            int smaller = leftLeaf + 1 < heapSize && arr[leftLeaf] > arr[leftLeaf + 1] ? leftLeaf + 1 : leftLeaf;

            smaller = arr[index] < arr[smaller] ? index : smaller;

            if (smaller == index) {
                break;
            }

            swap(arr, index, smaller);
            index = smaller;
            leftLeaf = index * 2 + 1;
        }
    }

    /**
     * swap two number in the array
     * 
     * @param arr    array to be sway
     * @param first  first index of int number
     * @param second second index of in number
     */
    public static void swap(int[] arr, int first, int second) {
        if (arr[first] != arr[second]) {
            arr[first] = arr[first] ^ arr[second];
            arr[second] = arr[first] ^ arr[second];
            arr[first] = arr[first] ^ arr[second];
        }
    }

    /**
     * pop up the first number in the heap
     * 
     * @param arr
     * @return the first int number
     */
    public static int pop(int[] heap, int heapSize) {
        if (heap == null) {
            return -1;
        }

        swap(heap, 0, heapSize);
        heapify(heap, 0, heapSize);
        int number = heap[heapSize];

        return number;
    }

    public static void printTree(int[] arr, int heapSize) {

        int depth = (int) (Math.log(heapSize) / Math.log(2)) + 1;

        int index = 0;
        for (int hight = depth; hight > 0; hight--) {
            char[] spacesArr = new char[(1 << (hight - 1)) - 1];

            Arrays.fill(spacesArr, ' ');
            String spaces = new String(spacesArr);

            int number = (1 << (depth - hight));

            int upperLine = number / 2 == 0 ? 0 : 1;

            while (index < heapSize && number > 0) {

                System.out.print(spaces + arr[index++] + spaces);
                if (upperLine != 0) {
                    System.out.print(" ");
                }
                number--;

            }
            System.out.println("");

        }

    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 4, 70, 60, 50 }; // k = 4;
        int k = 4;
        System.out.println(Arrays.toString(arr));
        heapSort(arr, k);
        System.out.println(Arrays.toString(arr));

    }
}
