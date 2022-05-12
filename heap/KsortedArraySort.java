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

    public static void heapInsert(int[] arr, int index){
        

    }

    public static void heapify(){

    }

    /**
     * swap two number in the array 
     * @param arr array to be sway 
     * @param first first index of int number
     * @param second second index of in number 
     */
    public static void swap(int [] arr, int first, int second){
        if(arr[first]!= arr[second]){
            arr[first] = arr[first] ^arr[second];
            arr[second] = arr[first] ^ arr[second];
            arr[first] = arr[first] ^ arr[second];
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
        
    }
}
