import java.util.*;

public class Sets1{

    /**SPACE COMPLEXITY INCLUDES - 
     * input space
     * space created inside program to solve it optimally(extra space)-->ONLY THING IN OUR CONTROL. hence, by sc, we refer to this.
     * space reserved for output
     */

    //Q. given an array of size n and q queries. for every query check if element is present in array and return true/false accordingly.
    //O(Q.n)

    static boolean checkQuery(int[] arr , int num ){
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]==num){
                return true;
            }
        }
        return false;
    }

    static boolean isPresentHash(int[] arr , int num){
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0 ; i<arr.length ; i++){
            set.add(arr[i]);
        }

        return set.contains(num);
    }

    //given an array , print all elements which are unique.
    static void printUnique(int[] A){
        for(int i=0 ; i<A.length ; i++){
            boolean found = false;
            for(int j=0 ; j<i ; j++){
                if(A[i]==A[j]){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.print(A[i]+" ");
            }
        }
        System.out.println();
    }

    static void printUniqueHash(int[] A){

        HashSet<Integer> set = new HashSet<Integer>();
    
        for(int i=0 ; i<A.length ; i++){
            if(!set.contains(A[i])){
                System.out.print(A[i]+" ");
                set.add(A[i]);
            }
        }
        System.out.println();
    }

    //Q.given 2 arrays with distinct elements in each , print the common elements in them.
    static void printCommonInTwo(int[] A , int[] B){
        for(int i=0 ; i<A.length ; i++){
            if(checkQuery(B , A[i])){
                System.out.print(A[i]+" ");
            }
        }
        System.out.println();
    }

    static void printCommonInTwoHash(int[] A , int[] B){

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0 ; i<B.length ; i++){
            set.add(B[i]);
        }

        for(int i=0 ; i<A.length ; i++){
            if(set.contains(A[i])){
                System.out.print(A[i]+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc  =new Scanner(System.in);

        int[] A = {1,2,3,4,5,6,7};
        int[] B = {3,4,5,6,7,8,9};

        // int Q = sc.nextInt();
        // for(int i=0 ; i< Q ; i++){
        //     int num = sc.nextInt();
        //     System.out.println(checkQuery(A , num));
        // }

        //printUnique(A);

        //printCommonInTwo(A , B);

        //printUniqueHash(A);

        printCommonInTwoHash(A , B);

    }
}


/**
 * HashSet
 * HashSet<Integer> variable_name = new HashTag<Integer>();
 * 
 * variable_name.add(number);
 * 
 * (set is the name of the variable)
 * 
 * set.contains(number)-->true/false. -->O(1) !!
 * 
 * O(1) is not worst case , it is average time complexity. but the worst case is so improbable that we dont consider it.
 * 
 * set.size();
 * set.remove();
 * 
 * all  the functions above have a time complexity of 1.
 * 
 * set is very ggo for checking the presence of an element.
 */


//-----HW : IMPLEMENT ALL ABOVE FUNCTIONS USING HASHSETS.