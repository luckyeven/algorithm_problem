// findOddnumber1([1,1,1,1,2,2,2,3,3,3,3]); print 2

// findOddnumeber2([1,1,1,1,2,2,2,3,3,3,4,4,4,4]); print 2, 3

// time complex O(n), space complex O(1)
public class findNum {
    public static void main(String[] args) {
        int [] arr1 = {1,1,1,1,2,2,2,3,3,3,3};
        int [] arr2 = {1,1,1,1,2,2,2,3,3,3,4,4,4,4};

        findEvenNum1(arr1);
        findEvenNum2(arr2);
    }

    public static void findEvenNum1(int [] arr ){
        int eor = 0;
        for(int num : arr){
            eor ^= num;
        }

        System.out.println(eor);
    }

    public static void findEvenNum2(int [] arr){
        int eor = 0;
        for(int num: arr){
            eor ^= num;
        }
        
        // find most right one
        int rightOne = eor &(~eor +1);
        int onlyOne = 0;
     
        for(int num: arr){
            if((rightOne & num) == 1 ){
                onlyOne ^= num; // find one possible number out of two
            }
        }
        System.out.println(onlyOne+" "+ (onlyOne^eor));

    }


}
