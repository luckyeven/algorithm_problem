/** 
 * small sum problem
 * 
 * In an array, the numbers to the left of each number that are smaller than the current number are added up, 
 * which is called the small sum of the array. Find the small sum of an array.
 * 
 * 
 * Example: [1,3,4,2,5]
 * The left side of 1 is smaller than 1: no;
 * The number to the left of 3 that is smaller than 3: 1;
 * Numbers smaller than 4 to the left of 4: 1, 3;
 * Number to the left of 2 smaller than 2: 1;
 * Numbers smaller than 5 to the left of 5: 1, 3, 4, 2;
 * 
 * So the small sum is 1+1+3+1+1+3+4+2=16
 * 
 * @author Shifeng Song @luckyeven
 * @since 2022-05-06
 * @version 1.0
 */


public class SmallSum {

    public  static int findSmallSum(int [] arr){
        int minLength =2;
        if(arr == null || arr.length < minLength){
            return 0;
        }

        return process(arr,0,arr.length-1);
    }

    public static int process(int [] arr, int left, int right){
        if(left == right){
            return 0;
        }

        int mid = left + ((right - left) >> 1);

        return process(arr,left,mid) + process(arr, mid + 1, right) + merge(arr,left, mid, right);

    }

    public static int merge(int [] arr, int left, int mid, int right){
        int [] tmp = new int[right - left + 1];
        int first = left;
        int second = mid + 1;
        int idx = 0;

        int sum = 0;

        while(first <= mid && second <= right){
            sum += arr[first] < arr[second]? (right - second +1)* arr[first] : 0;
            tmp[idx++] = arr[first] < arr[second]? arr[first++]:arr[second++];
        }

        while(first <= mid){
            tmp[idx++] =  arr[first++];
        }

        while(second <= right){
            tmp[idx++] = arr[second++];
        }
        for(idx = 0; idx < tmp.length;idx++){
            arr[left +idx] = tmp[idx];
        }
       
        return sum;
    }
    public static void main(String[] args) {
        int [] arr = {1,3,4,2,5};
        System.out.println("The small sum is " + findSmallSum(arr));

    }
}
