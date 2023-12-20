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
     * GOOGLE , FACEBOOK
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
     * TC:O(A+B+C)
     */
    public static int[] minDiff(int[] A , int[] B , int[] C){
        int[] arr = {0};
        return arr;
    }

    /**
     * Q. given an array containing the heights of N walls . find maximimum amount of water getting accumulated between any 2 walls.
     *    A = 3,7,4,5,2 : ans = 10
     * brute-force : O(n^2)
     * two-pointer: TC:O(N) , SC:O(1)
     * 
     * HW - SOLVE THE QUESTION USING RECURSION (find space complexity in that case)
     */
    public static int maxWater(int[] A){
        int i=0;
        int j=A.length-1;
        int dist = A.length;
        int area = A.length*Math.min(A[i] , A[j]);
        int maxArea = area;
        while(i<j){
            dist = j-i;
            area = dist*Math.min(A[i] , A[j]);
            maxArea = Math.max(maxArea , area);
            if(A[i]<A[j]){
                i++;
            }else if(A[i]>A[j]){
                j--;
            }else{
                i++;
                j--;
            }
        }
        return maxArea;
    }

    /**
     * Q. given an array of size n and an int B. return the minimum number of swaps required to bring all elements <= B together.
     * Ex: A = 1,10,12,14,3,5,10 : B=8 : ans=1(swapping 14 and 1)
     * Ex: A = 7,12,19,11,6,15,9,14,9 : B=10 : ans=2(swap 7 and 15 , then 9 and 14)
     */

    public static void main(String[] args){
        
        int[] arr = {-3,0,1,3,6,8,11,14,21,25};
        int[] arr2 = {3,7,4,5,2};

        // System.out.println(checkDiff(arr,5));
        System.out.println(maxWater(arr2));
    }
}