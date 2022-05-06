/**
 * This MergeSort program implement a merge sort algorithm
 * 
 * @author Shifeng Song @luckyeven
 * @since 2022-05-06
 * @version 1.0
 */


import java.util.Arrays;
public class MergeSort {

    static final int MINIMUM_LENGTH_OF_ARRAY = 2;

    public static void sort(int [] arr){
        if(arr.length < MINIMUM_LENGTH_OF_ARRAY || arr == null){
            return;
        }

        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr, int left, int right){
        if(left == right){
            return;
        }

        int mid = left + ((right - left) >> 1);
        process(arr,left,mid);
        process(arr,mid+1,right);
        merge(arr,left,mid,right);

    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] tmp = new int[right-left +1];
        // index of arr
        int i = 0; 
        int first = left;  
        int second = mid + 1;  

        while(first <= mid && second <= right){
            tmp[i++] = arr[first] <= arr[second]? arr[first++]:arr[second++];
        }

        while(first <= mid){
            tmp[i++] = arr[first++];
        }

        while(second <= right){
            tmp[i++] = arr[second++];
        }

        for( i = 0;i< tmp.length; i++){
            arr[left + i] = tmp[i];
        }


    }

    public static void main(String[] args) {
        int [] arr = {12,21,634,651,651,654,1,361,654,651,31,3,4,697,9,4,1,3,16,49,64,1,631,65,
            6,4,613,165,749,84,981,13,165,165,4,94,961,65,165,46,87,41,6321,661,654,64,9,4,61,4156,
            65,165,165,132,132,4,3,1,3,6,54,1,31,98,7,9,8,5,63,3,1,85694,651,563,65,4,651,64,651,698,47,61,654,654,651,65,165,46,54};

        sort(arr);
        System.out.println(Arrays.toString(arr));

        int [] arr1 = {5,9,6,3,1,4,0};
        sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
