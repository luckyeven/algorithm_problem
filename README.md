Algorithm Note
----------



# Merge Sort

### 1.Basic Ideas
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/merge.png?raw=true" width="98.39%" height="98.39%">

* Advantage: Stable, worst time complexity is O(n log n)  
* Disadvantage: O(n) space complexity

> `A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output.`

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
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/bucketSort.png" width="98.39%" height="98.39%"> 
# Time complexity Cheat Sheet
<img src="https://github.com/luckyeven/algorithm_problem/blob/main/picture/sorts.jpg?raw=true" width="98.39%" height="98.39%">
