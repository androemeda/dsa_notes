class Heaps2{

    /**
     * Q. given an array. find the k smallest elements.
     * Ex: 7,2,9,1,10,3,5,8,12,50 : k=5
     *     ans = 7,2,1,3,5 (order doesnt matter)
     * 
     * using minHeap: TC : O(N)+O(KlogN)
     *                SC : O(N)
     * 
     * using maxHeap: TC : O(K)+O((N-K)logK) = O(K)+O(NlogK) (if K<<N)
     *                SC : O(K) (space is optimized)
     */
    public static int[] kSmallest(int[] A){

    }

    /**
     * Q. given a K-sorted array (elements are present at max k distance apart from their position in sorted array). sort the array.
     * Ex: 3,2,1,5,6,4 --> 1,2,3,4,5,6
     * 
     * TC : O((N-K)logK)
     * SC : O(K)
     */

    /**
     * 
     * HEAP SORT - MOST OPTIMAL SORTING ALGORITH TILL NOW
     * 
     * (find out why it is not implemented inside the collections framework)
     * 
     * Q.sort any array.
     * Ex: 7,3,2,4,1,6,8
     * 
     * TC:O(NlogN)
     * SC:O(1)
     */
    public static void kSorted(int[] A){

    }

    /**
     * GOOGLE , FACEBOOK , AMAZON (very frequently asked)
     * Q. MEADIAN OF A STREAM OF INTEGERS
     *    given a stream of integers , find the median with each insertion.
     * Ex: 4         : 4
     *     4,6       : 5
     *     4,6,3     : 4
     *     4,6,3,2   : 3
     *     4,6,3,2,9 : 4
     * 
     * approach 1 : sort data with every insertion (n^2logn)
     * approach 2 : insert new element in correct position according to sorted order (n^2)
     * approach 3 : we need first n/2 elements at one palce(max heap) and next n/2 elements at another place(min heap)
     */

    public static void main(String[] args){

    }
}

/**
 * 
 * PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
 * 
 * pq.add();
 * pq.peek();
 * pq.poll();
 * 
 * how to use comparator when objects are passes
 * 
 * how to use it a a max heap
 */