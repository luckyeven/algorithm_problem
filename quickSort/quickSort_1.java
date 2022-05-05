import java.util.Arrays;
/**
 *  Quick sort version 1
 *  average time complex O(NlogN), worst time complex O(N^2)
 *  
 */
public class quickSort_1 {

    public static void quickSort(int [] arr){
        if(arr == null || arr.length <2 ){
            return;
        }
        process(arr,0,arr.length -1);


    }

    public static void process(int [] arr, int left, int right ){
        if(left<right){
            int pointers[] = partition(arr,left,right);
            process(arr, left, pointers[0] -1);
            process(arr, pointers[1]+1, right);
        }


        
    }

    // sort arr, return a list of two index 
    // [N1,N2, ..., Nn] -> [<Nn] [==Nn] [>Nn]
    public static int[] partition(int[] arr, int left, int right){


        
        int less = left - 1;
        int more = right;
      
        while(left < more){
            if(arr[left]<arr[right]){
                swap(arr,++less,left++);
            }else if(arr[left]> arr[right]){
                swap(arr,--more,left);
            }else{
                left++;
            }
        }

        swap(arr,more,right);
        return new int[] {less +1, more}; 
    }

    public static void swap(int [] arr, int left, int right){
        if(left == right){
            return;
        }

        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];
    }
    public static void main(String[] args) {
        int [] arr = {4,5,1,5,7,6,3,10,10,8};
        quickSort(arr);
        System.out.println("Quick sorted: "+ Arrays.toString(arr));

    }
}
