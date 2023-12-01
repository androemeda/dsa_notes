import java.util.*;

public class Sets2{

    //return the first element repeating int the array.
    public static int firstRepeatingElement(int[] A){
        int ans = -1;

        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();

        int lowestIndex=1 ;
        int index = 1;
        for(int i=0 ; i<A.length ; i++){

            if(map.containsKey(A[i]))
            map.put(A[i] , index);//value --> index in the initial set.
            index++;
        }

        return ans;
    }

    //given an array , write a function which returns true if there exists a pair i,j such that A[i]+A[j]==k and i!=j
    public static boolean checkSum(int[] A , int k){
        HashSet<Integer> set = new HashSet<Integer>();
    
        for(int i=0 ; i<A.length ; i++){
            if(set.contains(k-A[i])){
                return true;
            }
            set.add(A[i]);
        }
        return false;
    }


    //given an array, print all elements which occur odd number of times.
    public static void printOddFrequencyElements(int[] A){

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0 ; i<A.length ; i++){
            int frequency = 0;
            for(int j=0 ; j<A.length ; j++){
                if(A[i]==A[j]){
                    frequency++;
                }
            }
            if(frequency%2 != 0){
                set.add(A[i]);
            }
        }
        System.out.println(set);
    }

    public static void printOddFrequencyElementsHashSet(int[] A){
        //add every element to the set  and remove the element if already present in the set.
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0 ; i<A.length ; i++){

            if(set.contains(A[i])){

            }
        }
    }

    public static void main(String[] args){
        //System.out.println(checkSum(new int[]{1,2,3,4} , 5));

        //printOddFrequencyElements(new int[] {1,2,2,3,4,4,4});

        int[] A = {3,4,5,2,8,1,5,4,7,8,3,9,1,2};

        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
        for(int i=0 ; i<A.length ; i++){
            //check if the key A[i] is present in map.
            if(map.containsKey(A[i])){
                int freq = map.get(A[i]);
                map.put(A[i] , freq+1);
            }
            else{
                map.put(A[i] , 1);
            }
        }
        //for each , iterator--->explore.
    }
}


/**
 * HashMap<key , value>
 * given a key , value can be fetched in O(1) tc.
 * 
 * HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
 * 
 * map.put(2 , 1);
 * 
 * map.containsKey();
 * 
 * map.get(2)--> returns value associated with key==2 
 */

/**
 * ITERATING OVER VALUE IN A HASH_MAP USING FOR EACH LOOP.
 * 
 * HASH_MAP
 * for(Map.Entry<String , Integer> e : map.entrySet()){
 *    System.out.println(e.getKey());
 *    System.out.println(e.getValue());
 * }
 * 
 */