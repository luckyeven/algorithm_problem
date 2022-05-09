/**
 * The HeapSort program implements a heap sort algorithm
 * 
 * @author Shifeng Song @luckyeven
 * @since 2022-05-06
 * 
 */

 import java.util.Arrays;
public class HeapSort {

    
    public static void heapInsert(int[] arr, int index){
        
      
        // big root pile
        while(arr[index] > arr[(index-1) /2]){
            swap(arr, index, (index-1)/2);
            index = (index -1) /2; 
        }
    }

    public static void swap(int[] arr, int left, int right){

        //  cause bug when arr[left] and arr[right] references to the same object.
        if( arr[left] != arr[right]){    

            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
        }
    }

    public static void main(String[] args) {
        int [] arr = {3, 6, 3, 5, 9, 3, 10, 2, 1, 1};
        int [] bigPile = new int[arr.length];

       /*  swap(arr, 0, 9);
        System.out.println("Test swap: " +Arrays.toString(arr)); */
        
        
        // [10, 6, 9, 3, 5, 3, 3, 2, 1, 1]
        System.out.println("Test heapInsert: \n");  
        for(int i = 0; i< bigPile.length;i++){
            bigPile[i] = arr[i];
            heapInsert(bigPile, i);
            System.out.println(Arrays.toString(bigPile));
        }
    }

}
