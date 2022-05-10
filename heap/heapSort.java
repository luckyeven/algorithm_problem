
/**
 * The HeapSort program implements a heap sort algorithm
 * 
 * @author Shifeng Song @luckyeven
 * @since 2022-05-09
 *  
 */

import java.util.Arrays;

import java.lang.Math;

public class HeapSort {

    /**
     * construct a heap tree from index, moving up
     * 
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {

        // big root pile
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int left, int right) {

        // cause bug when arr[left] and arr[right] references to the same object.
        if (arr[left] != arr[right]) {

            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
        }
    }

    /**
     * up down create a heap structure from index
     * 
     * @param arr
     * @param index    consider as a root
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int leftChild = index * 2 + 1;

        while (leftChild < heapSize) {
            int large = leftChild + 1 < heapSize &&
                    arr[leftChild + 1] > arr[leftChild] ? leftChild + 1 : leftChild;

            large = arr[large] > arr[index] ? large : index;

            if (large == index) {
                break;
            }

            swap(arr, large, index);
            index = large;
            leftChild = index * 2 + 1;
        }
    }

    /**
     * Binary tree visualization
     * 
     * @param arr
     * @param heapSize
     */
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

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;

        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }

    }

    public static void main(String[] args) {

        int[] arr = { 3, 6, 3, 5, 9, 3, 10, 2, 1, 1 };
        heapSort(arr);// O(NlogN)
        System.out.println(Arrays.toString(arr));
        /*
         * int heapSize ;
         * 
         * // heapify the whole array
         * for(heapSize = 0; heapSize < arr.length; heapSize++){
         * heapInsert(arr, heapSize);
         * 
         * }
         * 
         * System.out.println("Heap Array:");
         * printTree(arr, heapSize);
         * 
         * // Heap sort start from here
         * 
         * while(heapSize>0){
         * swap(arr, 0, --heapSize);
         * heapify(arr,0 , heapSize);
         * }
         * 
         * System.out.println("Sorted array: \n"+ Arrays.toString(arr));
         */

    }

}
