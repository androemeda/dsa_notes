import java.util.*;
class SearchingProblems{

    /**
     * Q. given an array and a number k . find the maximum length l such that all sub-arrays of length l have sum<=k.
     *      OR  there is no sub-array with a sum>k. 
     * Ex: A = 1,2,3,4,5 : k=10 : ans=2 (all sub-arrays of length 2 have sum<10)
     * Ex: A = 5,17,100,11 : k=130 : ans=3
     * 
     * if "sum of sub-arrays" comes "prefix-sum" should come to our mind.
     * 
     * min possible ans = 0 , max possible value = length of array
     * s=0 , e=A.length
     * 
     * first do in SC:O(N) then optimize it for SC:O(1)
     * TC : O(nlogn)
     */
    public static int solve(int[] A){
        int s = 0;
        int e = A.length;
        int ans = 0;

        while(s<=e){
            mid = (s+e)/2;
            if(check2(A,mid,k)){
                ans = mid;
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return ans;
    }

    public static boolean check2(int[] A , int length , int maxSum){
        int s = 0;
        int e = length-1;
        while(e<A.length){
            sum += 
        }
    }

    // /**
    //  * Q. given an array A[n] and Q queries (L,R) . find the minimum index i in the range [L,R] such that A[i] is a 
    //  *    special number.
    //  *    special number --> sum of digits < 15. 
    //  * Ex: A = 3,15,99,128,973,16,387,192
    //  *     Qs : ans = [0,3] : 0 , [4,7] : 5 , [1,5] : 1 , [3,4] : -1
    //  */

    // public static int ceilOfN(ArrayList<Integer> A , int n){
    //     int ans = -1;
    //     int s = A.get(0);
    //     int e = A.get(A.size()-1);
    //     while(s<=e){
    //         int mid = (s+e)/2;
    //         if(A.get(mid)<n) s=mid+1;
    //         if(A.get(mid)==n) return A.get(mid);
    //         if(A.get(mid)>n){
    //             ans = A.get(mid);
    //             e=mid-1;
    //         }
    //     }
    //     return ans;
    // }

    // public static int sumOfDigits(int n){
    //     int sum=0;
    //     while(n>0){
    //         sum += n%10;
    //         n/=10;
    //     }
    //     return sum;
    // }

    // public static void specialIndex(int[] A , int[][] Q){
    //     int ans = -1;

    //     //create a list of special indices . this will already be sorted.
    //     ArrayList<Integer> list = new ArrayList<Integer>();
    //     for(int i=0 ; i<A.length ; i++){
    //         if(sumOfDigits(A[i])<15){
    //             list.add(i);
    //         }
    //     }

    //     //find ceil of A[L] in list and check weather it is less than or equal to A[R]
    //     for(int i=0 ; i<Q.length ; i++){
    //         int L = Q[i][0];
    //         int R = Q[i][1];
    //         if(ceilOfN(list , A[L])<A[R] && ceilOfN(list , A[L])!=-1){
    //             System.out.println(ceilOfN(list , A[L]));
    //         }else{
    //             System.out.println(-1);
    //         }
    //     }
    // }

    /**
     * Q. given an array. find the kth minimum of the array. (i.e. element present at k-1 index if array was sorted)
     * constraints: SC:O(1) , array can not be changed , 1<=A[i]<=10^9 .
     * Ex: A = 2,1,4,3,2 : k=3 : ans=2
     * Ex: A = 2,1,4,3,2,1 : k=1 : ans=1
     * Ex: A = 7,12,15,15,9,18,15,18,15 : k=4 : ans=15
     * 
     * there are k-1 elements less than or equal to kth minimum
     * s=1 , e=10^9
     * create a function to return the number of elements smaller than or equal to a given number.
     */

    public static int smallerElementsCount(int[] A , int num){
        int count=0;
        for(int i=0; i <A.length ; i++){
            if(A[i]<=num){
                count++;
            }
        }
        return count-1;        // -1 to make sure that the element itself is not counted.
    }
    public static int kthMinimum(int[] A , int k){
        int s = 1;
        int e = Integer.MAX_VALUE;
        int ans = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            int count = smallerElementsCount(A,mid);
            if(count<k-1){
                s=mid+1;
            }
            if(smallerElementsCount(A,mid)>=k-1){
                ans = mid;
                e=mid-1;
            }
        }
        return ans;
    }

    /**
     * Q. PAINTER'S PARTITION PROBLEM
     *    given n tasks and k workers.
     *    A[n]--> time taken for each task.
     *    find min time in which all tasks can be done.
     *    Ex: k=3
     *    A = [   3,5,1,7,8   ,2,5,3,10,1,4   ,7,5,4,6]
     *               24          25               22    ---> ans = 25min.
     *    minimise the maximum ==> binary search
     *target to search here is "sum of a sub-array" and minimze the maximum.
     *search space: s=max(A) when there are n workers. e=summation(A) when ther is single worker.
     *BUT , all the value present from s to e cannot be an answer.
     *our answer could be the maximum sum of the k sub-arrays created out of A.
     * TC: O(nlog(Range)) (range=e-s).
     */

    public static int arraySum(int[] A){
        int sum=0;
        for(int i=0 ; i<A.length ; i++){
            sum += A[i];
        }
        return sum;
    }
    public static int arrayMax(int[] A){
        int ans=A[0];
        for(int i=0 ; i<A.length ; i++){
            ans = Math.max(ans , A[i]);
        }
        return ans;
    }
    public static boolean check(int[] A , int k , int T){
        //return true if it is possible to perform all tasks within time T.
        int worker=1;
        int time=0;
        for(int i=0 ; i<A.length ; i++){
            time+=A[i];
            if(time>T){
                worker++;
                time=A[i];
            }
        }
        if(worker<=k) return true;
        return false;
    }

    public static int painterPartition(int[] A , int k){
        int s = arrayMax(A);
        int e = arraySum(A);
        int ans=s;
        while(s<=e){
            int mid = s+(e-s)/2 ;
            if(check(A,k,mid)){
                ans = mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6};

        int[] arr2 = {7,12,15,15,9,18,15,18,15};

        int[] arr3 = {3,15,99,128,973,16,387,192};
        int[][] Q = {{0,3},{4,7},{1,5},{3,4}};

        // System.out.println(painterPartition(arr , 3));
        // System.out.println(kthMinimum(arr2 , 4));
        // specialIndex(arr3 , Q);
    }
}