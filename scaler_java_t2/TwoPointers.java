class TwoPointer{

    /**
     * AMAZON , FACEBOOK
     * Q. given a sorted (asc.) array and a number k. check if there exists a pair of elements A[i],A[j] such that , A[i]+A[j]=k , i != j .
     * Ex: A = 3,7,8,12,19 : k=15 : ans=true
     * hashmap : TC:O(N) , SC:O(N)
     * two-pointers : TC:O(N) , SC:O(1)
     */
    public static boolean checkSum(int[] A , int k){
        int i=0 ; 
        int j=A.length-1;

        while(i<j){
            if(A[i]+A[j]==k) return true;
            else if(A[i]+A[j]>k) j--;
            else i++;
        }
        return false;
    }

    /**
     * Q. given a sorted array(asc.) and a number k . check if there exists a pair of elements A[i],A[j] such that A[i]-A[j]=k . i != j. k always >=0 .
     * Ex: A = -3,0,1,3,6,8,11,14,21,25 : k=5 : ans = true
     * hashmap : TC:O(N) , SC:O(N)
     * two-pointers : TC:O(N) , SC:O(1)
     * 
     * HW : try the question when the condtion k>=0 is ot given (this condition wont be given in contest) . see lec at 51.00
     */
    public static boolean checkDiff(int[] A , int k){
        int i = 1;
        int j = 0;
        while(i<A.length){
            if(A[i]-A[j]==k) return true ;
            else if(A[i]-A[j]>k){
                j++;
                if(i==j) i++;
            }
            else i++;
        }
        return false;
    }

    /**
     * AMAZON
     * Q. given three sorted arrays A,B,C . find i,j and k such that max(A[i],B[j],C[k])-min(A[i],B[j],C[k]) is minimized.
     * Ex: A = 3,14,16,23    : i = 3 : A[i] = 23
     *     B = -6,23,24,30   : j = 1 : B[j] = 23
     *     C = -15,15,26,31  : k = 2 : C[k] = 26
     *     min = 23 , max = 26 : diff = 3(minimum)
     */
    public static int[] minDiff(int[] A , int[] B , int[] C){
        
    }


    public static void main(String[] args){
        
        int[] arr = {-3,0,1,3,6,8,11,14,21,25};

        System.out.println(checkDiff(arr,5));
    }
}