class Searching2{

    /**
     * Q. given a sorted array and a target. find and return the smallest index in which the target is present
     * (left most occurence of target). if target not present , return -1.
     * Ex: -5,-5,-3,0,0,0,1,1,1,1,2,2,2,3,8 : k=0-->ans=3 : k=2-->ans=10 : k=8-->ans=14
     */
    public static int smallestIndex(int[] arr , int target){
        int s = 0;
        int e = arr.length-1;
        int ans = -1;

        while(s<=e){
            int mid = (s+e)/2;

            if(target==arr[mid]){
                ans = mid;
                e = mid-1;
            }else if(target<arr[mid]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }

    /**
     * Q. given a sorted array and a target. find and return the largest index in which the target is present
     * (right most occurence of target). if target not present , return -1.
     * Ex: -5,-5,-3,0,0,0,1,1,1,1,2,2,2,3,8 : k=0-->ans=5 : k=2-->ans=12 : k=8-->ans=14
     */
    public static int largestIndex(int[] arr , int target){
        int s = 0;
        int e = arr.length-1;
        int ans = -1;

        while(s<=e){
            int mid = (s+e)/2;

            if(target==arr[mid]){
                ans = mid;
                s = mid+1;
            }else if(target<arr[mid]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }

    /**
     * AMAZON
     * given a sorted array and a target, return the frequency of the target in the array.
     * TC: O(logN)
     * SC: O(1)
     */
    public static int frequency(int[] arr , int target){
        int lmi = smallestIndex(arr , target);
        int rmi = largestIndex(arr , target);
        return rmi-lmi+1;
    }

    /**
     * GOOGLE,FACEBOOK,TWITTER,APPLE,AMAZON,MICROSOFT,WALMART,NETFLIX,FKIPKART,MYNTRA
     * Q. given an array which is sorted rotated  , find a target(return its index) (all elements are distinct)
     * Ex: 10 , 20 , 30 , -1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9
     * HW: implement using 2 functions as well as in a single function.
     */

    public static int findPivot(int[] arr){
        int first = arr[0];
        int s=0;
        int e=arr.length-1;
        int pivot = 0;

        if(arr[0]<arr[arr.length-1] && arr[0]<arr[1]) return 0;
        if(arr[0]>arr[arr.length-1] && arr[arr.length-2]>arr[arr.length-1]) return arr.length-1;

        while(s<=e){
            int mid=(s+e)/2;
            pivot = mid;

            if(arr[mid]<first){
                e = mid-1;
            }else if(arr[mid]>first){
                s = mid+1;
            }
        }
        return pivot;
    }

    public static int binarySearchInRangeTargetIndex(int[] A , int s , int e , int target){
        while(s<=e){
            int mid = (s+e)/2;
            if(A[mid]==target) return mid;
            else if(A[mid]<target) s=mid+1;
            else e=mid-1;
        }
        return -1;
    }

    public static int sortedRotated(int[] arr , int target){
        int pivot = findPivot(arr);
        if(target==arr[pivot]) return pivot;
        if(target<=arr[pivot-1]) return binarySearchInRangeTargetIndex(arr , 0 , pivot-1 , target);
        if(target>=arr[pivot+1]) return binarySearchInRangeTargetIndex(arr , pivot+1 , arr.length-1 , target);
        return -1;
    }

    /**
     * Q. given an unsorted array:
     *    all elements of the array occur twice , except one element.
     *    all duplicates will be next to each other.
     * Ex: 5,5,3,3,7,7,0,0,6,9,9,2,2 : ans=8
     * Find index of the element occuring exactly once.
     * brute-force: TC:O(N) - check every element with its neighbour. (n/2 iterations)
     * non-duplicate element will always occur on an even index.
     * in paired  elements , first element occurs on even and second on odd before the unique element. after unique element, this reverses.
     */
    public static int unsortedDuplicates(int[] arr){
        
        int s=0;
        int e=arr.length-1;

        if(arr.length==1) return 0;
        if(arr[0] != arr[1]) return 0;
        if(arr[arr.length-1] != arr[arr.length-2]) return (arr.length-1) ;

        while(s<=e){
            int mid=(s+e)/2;

            if(mid%2 == 0){
                if(arr[mid] == arr[mid+1]) s=mid+2;
                else if(arr[mid] == arr[mid-1]) e=mid-2;
                else return mid;
            }

            if(mid%2 != 0){
                if(arr[mid] == arr[mid+1]) e=mid-1;
                else if(arr[mid] == arr[mid-1]) s=mid+1;
                else return mid;
            }
        }
        return -1;
    }

    /**
     * GOOGLE
     * Q. given an unsorted array . return any local minima(element should be smaller than its neighbours)
     *    all elements are distinct.
     * Ex: 10,3,2,6,1,7,5 : possible answers=2,1,5
     * approach 1: tc(N) --> find minimum.
     * approach bs: apply bs to choose the half where answer is gaurenteed to be present.
     *              all arrays will have atleat one local minima
     *              TC:O(logN)
     *              SC:O(1)
     */
    public static int localMinima(int[] A){

        if(A.length==1) return 0;
        if(A[0]<A[1]) return 0;
        if(A[A.length-1]<A[A.length-2]) return (A.length-1);

        int s=1;
        int e=A.length-2; 

        while(s<=e){
            int mid = (s+e)/2;

            if(A[mid]<=A[mid+1] && A[mid]<=A[mid-1]) return mid;
            else if(A[mid]<=A[mid-1] && A[mid]>=A[mid+1]) s=mid+1;
            else e=mid-1;
        }
        return 0;
    }

    public static void main(String[] args){
        
        int[] arr = {-5,-5,-3,0,0,0,1,1,1,1,2,2,2,3,8};

        int[] arr2 = {10,20,30,-1,2,3,4,5,6,7,8,9};

        int[] arr3 = {5,5,3,3,7,7,0,0,6,9,9,2,2};

        int[] arr4 = {10,3,2,6,1,7,5,8};

        // System.out.println(sortedRotated(arr2 , 10));
        // System.out.println(findPivot(arr2));

        // System.out.println(binarySearchInRangeTargetIndex(arr2 , 3 , 11 , 20));

        // System.out.println(smallestIndex(arr , 8));
        // System.out.println(largestIndex(arr , 8));

        // System.out.println(unsortedDuplicates(arr3));

        System.out.println(localMinima(arr4));
    }
}









/**
 * if you have to find an element then array should be sorted for performing binary search.
 * but we can also apply bs in non-sorted array.
 * bs is basically just dividing the array in half in each step.
 */