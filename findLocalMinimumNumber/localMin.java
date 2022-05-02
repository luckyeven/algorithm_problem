/*
Given an array arr[0 .. n-1] of distinct integers, the task is to find a local minima in it.
We say that an element arr[x] is a local minimum if it is less than both its neighbors. 
for corner elements, we need to consider only one neighbor for comparison.
There can be more than one local minima in an array, we need to find one of them.

Requirement: time complex O(logN)

Examples: 
 

Input: arr[] = {9, 6, 3, 14, 5, 7, 4};
Output: Index of local minima is 2
The output prints index of 3 because it is 
smaller than both of its neighbors. 
Note that indexes of elements 5 and 4 are 
also valid outputs.

Input: arr[] = {23, 8, 15, 2, 3};
Output: Index of local minima is 1

Input: arr[] = {1, 2, 3};
Output: Index of local minima is 0

Input: arr[] = {3, 2, 1};
Output: Index of local minima is 2
*/
public class localMin {

    public static int findAllLocalMin(int [] arr, int first, int last){
        int mid =first + (last - first)/2;

        if(mid == 0){return mid;}
        if(arr[first]< arr[first+1]){return first;}
        if(arr[last]< arr[last-1]){return last;}


        if( arr[mid -1] > arr[mid] && arr[mid] <arr[mid+1] ){
            return mid;
        }else if(arr[mid]< arr[mid-1]){
            return findAllLocalMin(arr, mid+1, last );
        }
        return findAllLocalMin(arr, first, mid+1);
    }

    public static int findLocalMin(int[] arr, int l){
        return findAllLocalMin(arr,0,l-1);
    }
    public static void main(String[] args) {
        int [] arr = {3,2,1};
        int i = findLocalMin(arr, arr.length);
        System.out.println("Index of local minima is "+ i );
    }

}
