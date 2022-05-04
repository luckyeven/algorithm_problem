/**
 * Given an integer array nums, return the number of reverse pairs in the array.
 * 
 * Example: Given array [3,2,4,5,0], output 5. reverse pairs: {3,2},{3,0},{2,0},{4,0},{5,0}.
 *          
 */

public class reversePair {
    
    public static int findReversePair(int []  arr){
        if(arr == null || arr.length <2){
            return 0;
        }
        
        return process(arr, 0, arr.length -1);
    }

    public static int process(int [] arr, int left, int right){
        if(left == right){
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return process(arr,left,mid) + process(arr, mid + 1, right) + merge(arr,left,mid, right);

    }

    public static int merge(int [] arr, int left, int mid, int right){
        int [] tmp = new int[right - left + 1];
        int firstP = left;
        int secondP = mid + 1;
        int idx = 0;
        int sum = 0;

        while(firstP <= mid & secondP <= right){
            sum += arr[firstP] > arr[secondP]? (right - secondP + 1):0;
            tmp[idx++] = arr[firstP] > arr[secondP]? arr[firstP++]:arr[secondP++];
        }

        while(firstP <= mid){
            tmp[idx++]  =  arr[firstP++];
        }

        while(secondP <= right){
            tmp[idx++] = arr[secondP++];
        }

        for(idx = 0; idx< tmp.length; idx ++){
            arr[left + idx] = tmp [idx];
        }

        return sum;

    }
    public static void main(String[] args) {
        int [] arr = {3,2,4,5,0};

        System.out.println(findReversePair(arr));
    }
}
