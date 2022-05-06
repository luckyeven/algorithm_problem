/**
 * The HeapSort program implements a heap sort algorithm
 * 
 * @author Shifeng Song @luckyeven
 * @since 2022-05-06
 * 
 */

public class HeapSort {


    public static void heapInsert(int[] arr, int i, int, index){
        
    }

    public static void swap(int[] arr, int left, int right){
        if( arr[left] != arr[right]){    //  cause bug when arr[left] and arr[right] references to the same thing.

            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
        }
    }

    public static void main(String[] args) {
        int [] arr = {3, 6, 3, 5, 9, 3, 10, 2, 1, 1};
    }

}
