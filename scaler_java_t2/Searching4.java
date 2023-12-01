import java.util.*;
class Searching4{

    /**
     * Q.given an array which is sorted and has all elements distinct.
     *   find any magic index of the array.
     *   magic index is that for which value is same as the index. if there are multiple , return any one.
     * Ex. -1 0 1 2 4 10 : ans=4
     * Ex. -1 10 12 13 : ans=-1
     */
    public static int magicIndex(int[] A){
        int s=0;
        int e=A.length-1;

        while(s<=e){
            int mid=(s+e)/2;
            if(A[mid]==mid) return mid;
            if(A[mid]<mid) s=mid+1;
            if(A[mid]>mid) e=mid-1;
        }
        return -1;
    }

    /**
     * Q. given 2 sorted arrays.
     *    find the median of the array which is the result of merging the 2 arrays.
     * Ex. A: 3 , 5 , 7 , 10 , 12
     *     B: 1 , 2 , 8 , 10 , 11 , 13 , 16
     *     merged: 1,2,3,5,7,8,10,10,11,12,13,16
     *     median = ans = (8+10)/2 = 9
     * solve in TC better than (A+B). 2 pointer method will take (A+B) TC.
     * 
     * TC: O(log(min(A,B)))
     * 
     * use same approach to find kth element of merged array.
     */
    public static int median(int[] A , int[] B){
        return 1;
    }

    /**
     * company: tower research(famous for asking difficult questions)
     * Q. SMALLEST GOOD BASE
     *   given an integer , return the smallest good base.
     *   good base: the base for which n can be represented as all 1's
     * Ex. 3 --> (3)_2 = 11 : ans=2
     * Ex. 13--> (13)_3 = 111 , (13)_12 = 11 : ans=3(smallest base)
     * 
     * brute force: nlogn
     * bs: logn*logn
     */
    public static int goodBase(int n){
        int s=2;
        int e=n-1;
        int ans = n-1;
        while(s<=e){
            int mid = (s+e)/2;
            int num=0;
            int pow = 0;
            while(num<n){
                num += Math.pow(mid , pow);
                if(num==n){
                    ans = mid;
                    e=mid-1;
                    break;
                }
                pow++;
            }
            
        }
        return ans;
    }

    public static void main(String[] args){
        // int[] arr = {-1,0,1,2,4,10};
        // System.out.println(magicIndex(arr));
        System.out.println(goodBase(13));
    }
}