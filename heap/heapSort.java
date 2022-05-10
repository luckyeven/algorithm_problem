
/**
 * The HeapSort program implements a heap sort algorithm
 * 
 * @author Shifeng Song @luckyeven
 * @since 2022-05-06
 * 
 */

import java.util.Arrays;

import java.lang.Math;

public class HeapSort {

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

        int[] arr = { 3, 6, 3, 5, 9, 3, 10, 2, 1, 1 };
        int heapSize = arr.length;
        // int [] bigPile = new int[arr.length];

        /*
         * swap(arr, 0, 9);
         * System.out.println("Test swap: " +Arrays.toString(arr));
         */

        // [10, 6, 9, 3, 5, 3, 3, 2, 1, 1]

        /*
         * System.out.println("Test heapInsert: \n");
         * for(int i = 0; i< bigPile.length;i++){
         * bigPile[i] = arr[i];
         * heapInsert(bigPile, i);
         * System.out.println(Arrays.toString(bigPile));
         * }
         */

        /*
         * System.out.println("Text heapify");
         * 
         * 
         * heapify(arr, 1, heapSize);
         * System.out.println(Arrays.toString(arr));
         */

        printTree(arr, heapSize);
    }

}
