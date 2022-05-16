Algorithm Note
----------



# Merge Sort

### 1.Basic Ideas
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/merge.png?raw=true" width="98.39%" height="98.39%">

* Advantage: Stable, worst time complexity is O(n log n)  
* Disadvantage: O(n) space complexity

> `A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output.`
```JAVA Get mid point: 
mid = (Left + Right) / 2; // risk of overflow
    or
mid = Left + ((Right - Left) >> 1 ); 
```
### 2.Demo
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/mergeSort.gif?raw=true" width="98.39%" height="98.39%">

# Quick Sort

### 1.Basic Ideas
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/quickSort.png?raw=true" width="98.39%" height="98.39%"> 

* Advantage: quick
* Disadvantage: not stable, space complexity is log(n) on average, worst time complexity is O(n^2)

### 2.Demo
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/quickSort.gif?raw=true" width="98.39%" height="98.39%">

# Heap Sort
### 1.Basic Ideas

<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/heapSort.png?raw=true" width="98.39%" height="98.39%"> 

* Advantage: O(n log b) time complexity, O(1) space complexity
* Disadvantage: not stable, need to create a heap



### 2.Demo
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/heapSort.gif?raw=true" width="98.39%" height="98.39%">

### Question


> *  Given an almost sorted array where each element may be misplaced by no more than k positions from the correct sorted order, write a function to sort the array.  
> * [Solution](https://github.com/luckyeven/algorithm_problem/blob/main/heap/KsortedArraySort.java#L34)

# Bucket sort
### 1.Basic Ideas
Bucket Sort is a sorting algorithm that divides the unsorted array elements into several groups called buckets. Each bucket is then sorted by using any of the suitable sorting algorithms or recursively applying the same bucket algorithm.  

<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/bucketSort.png?raw=true" width="98.39%" height="98.39%"> 

----
* Best case: When all data can be equally distributed to each bucket.
* Worst case: When all data is assigned to one bucket.
------
* Different bucket sort
    * Counting Sort
    * [Radix Sort](https://github.com/luckyeven/algorithm_problem/blob/main/bucketSort/RadixSort.java#L1)  
    ```JAVA
    // pseudocode
    RADITSORT(array,begin,end){
        if array is null or array.length is 1 then
            return
        end if

        RADIX := 10; // since the base is 10
        Digits := FindMaxRadix(array)  // number of digits of the largest number in the array

        Let bucket be an array from begin to end
        let i,j:= int
        for digit is [1 to Digits] do
            Let counter be an array of 0 to 9 // [0,1,...9]
            for i is [begin to end] do
                j := getDigit(array,digit)
                counter[j]++
            end for
            
            for items in counter do
                item[N] = item[N] + item[N +1]// N start form 1
            end for
            
            for i:= [end to begin] do
                j:= getDigit(array[i]. digit)
                bucket[counter[j] -1] = array[i]
                counter[j]--
            end for

            copy bucket to array
        end for
    }
    ```

# Time complexity Cheat Sheet
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/sorts.jpg?raw=true" width="98.39%" height="98.39%">

* Stable Sort
    * Bubble Sort
    * Insertion Sort
    * Recursion(Merge) Sort
    * All Bucket Sort
* Unstable Sort
    * Selection Sort
    * Quick Sort
    * Heap Sort
> There is no perfect algorithm yet: None of any sorting algorithm has time complex of O(NlogN) , space complex O(1) and stable!
-----
# Recursion Time Complexity

```BUSH
T(N) = a * T(N/B) + O(N^d)  // Master formula 
Where:
N = size of input
a = number of sub-problems called in the recursion
N/b = size of each subproblem

1) logb(a) < d ; Time complexity  O(N^d)
2) logb(a) >ｄ；Time complexity O(N^logb(a))
3) logb(a) = d ; Time complexity O(N^d * logN)
```
------
# Fun Questions
> Q: Why does Java's Arrays.sort method use two different sorting algorithms for different types?  
A : For primitive types, it does not matter if change their relative position. Therefore, a unstable quicksort can be used. On the other hand, It could cause bugs if change the relative position of reference types, Therefore, a stable merge sort is performed.
