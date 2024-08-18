class Queues1{

    /**
     * Q. given a queue having n elements . reverse the first k elements of the queue.
     * Ex: 3,10,2,12,19,6,8,10,14 : k=4 : ans = 12,2,10,3,19,6,8,10,14
     * 
     * COULD BE DONE USING THE EXACT SAME QUEUE AS WELL
     * 
     * TC:O(N) : k dq  + k push + k pop + k enq + (N-k) dq + (N-k) dq = 2(N+k)
     * SC:O(N)
     */

    /**
     * AMAZON , MICROSOFT , ADOBE
     * Q. implement a queue using stacks.
     *    operations to be provided : enqueue(x) - adds element at end
     *                                dequeue() - removes first element
     *                                front() - returns front element without removing
     * Ex:e(5),e(4),e(7),fr()[returns 5],dq(),fr()[returns 4]
     * 
     * avg TC : O(1) (AMORTIZED TC : do one heavy operation to make sure remaing operations happen at low cost.)
     */

    /**
     * AMAZON
     * Q. generate first n numbers formed using the digits 1,2 and 3.
     * 
     * numbers created using 1,2 and 3 : 1,2,3,11,12,13,21,22,23,31,32,...
     */

    /**
     * SLIDING WINDOW MAXIMUM
     * Q. given an array A[N] , return an array containing the max of every window(sub-array) of size k.
     * 
     * Ex: 10,8,9,7,6,5,11,3 : k=3 : ans = 10,9,9,7,11,11
     * Ex: 1,3,-1,-3,5,3,6,7 : k=3 : ans = 3,3,5,5,6,7
     * 
     * TC: O(N)
     * SC: O(N) (in worst case)
     */
    public static int[] slidingWindowMax(int[] A , int k){

    }

    public static void main(String[] args){

    }
}
/**
 * 
 * EXAMPLES OF QUEUE IN COMPUTER-SCIENCE
 * 
 * queueing systems : kafka , rabbit mq , active mq
 * 
 */

/**
 * similar to stacks , queue is also an abstract data-type
 * abstract data type has functions which are specific to it.
 * 
 * functions of queue : enqueue(x) / add(x)
 *                      dequeue() / pop()
 *                      size()
 *                      isEmpty()
 * 
 * in queue operations are performed on both ends : add at rear end and remove from front end
 */

/**
 * explore dequeue library
 */