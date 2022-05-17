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

## Hash Table/Set
* Hash table is called unOrderedMap or unSortedMap in C++
* Hash table pass a copy when it's a primary type Hash table. Ex: HashMap<Integer>
* Hash table pass reference to the memory address (8bits long) when it's other type Hash table. Ex: HashMap<Student>
Set: Key only
```JAVA
HashSet<Integer> hashSet1 = new HashSet<>();
hashSet1.add(3); // add 3 to hash set
hashSet1.remove(3); // remove 3
System.out.println(hashSet1.contains(3)); // Return False
```
Map: Key -> Value
```JAVA
// unordered
HashMap<Integer, String> mapTest = new HashMap<>();
mapTest.put(1,"test1"); // add 
mapTest.put(1,"test2"); // edit
mapTest.put(2,"test3"); // add
System.out.println(mapTest.containsKey(1)); // return True
System.out.println(mapTest.get(1)); // return "test2"
mapTest.remove(2);
System.out.println(mapTest.get(2)); // return null         
```

#### Time complexity
* Best/Average Case for Searching/Insertion/Deletion are both O(1)  
* Worst case for searching/Insertion/Deletion are both O(n)
> Worst case: When all nodes are attached to the same linked list.

> Note: Hash table takes constant time, but this constant time is much bigger than a constant time for array.  
#### Space complexity  

Space complexity for hash map remains O(n) where:  
n = number of elements in the hash map.

## TreeMap/TreeSet

```JAVA
// TreeSet

// When key is not primitive type
Node A = new Node(5);
TreeSet<Node> treeSet = new TreeSet<>();
try{
    treeSet.add(nodeA)  // cause Error. comparator not provided
}catch (Exception e){
    System.out.println(e.getMessage());
}

TreeSet<Node> TreeSet = new TreeSet<>(new NodeComparator());  // provide comparator
try{
    TreeSet.add(nodeA)  // success
}catch (Exception e){
    System.out.println(e.getMessage());   
}
```
* TreeMap does not allow null key but allow multiple null values.
* TreeMap maintains order. It stores keys in sorted and ascending order.
```JAVA
// TreeMap(ordered)

// Key is primitive type 
TreeMap<Integer, String> treeMap1 = new TreeMap<>();
treeMap1.put(7, "This is 7"); 
treeMap1.put(5, "This is 5");
treeMap1.put(4, "This is 4");
treeMap1.put(3, "This is 3");
treeMap1.put(9, "This is 9");
treeMap1.put(2, "This is 2");
System.out.println(treeMap1.containsKey(5)); // return True
System.out.println(treeMap1.get(5));  // return This is 5
System.out.println(treeMap1.firstKey()); // return 2, as the treeMap is ordered
System.out.println(treeMap1.LastKey()); //return 9
System.out.println(treeMap1.floorKey(8)); // return 7
System.out.println(treeMap1.ceilingKey(8)); // return 9
System.out.println(treeMap1.floorKey(7)); // return 5
System.out.println(treeMap1.ceilingKey(7)); // return 8
treeMap1.remove(5);
System.out.println(treeMap1.get(5)); // return null
```

#### Time Complexity
* TreeMap has complexity of O(logN) for insertion and lookup.

------

# Fun Questions
> Q: Why does Java's Arrays.sort method use two different sorting algorithms for different types?  
A : For primitive types, it does not matter if change their relative position. Therefore, a unstable quicksort can be used. On the other hand, It could cause bugs if change the relative position of reference types, Therefore, a stable merge sort is performed.
