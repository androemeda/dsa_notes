class LinkedLists3{

    /**
     * Q. reverse a LL using recursion.
     * TC(n) = TC(n-1) + O(1) --> TC:O(N) . REVISE FINDING TC OF RECURSIVE FUNCTIONS USING FORMULA .
     * SC:O(N)
     * If "tail recursion" is used , the SC would be 1. 
     */
    public static ListNode reverseRec(ListNode head){
        //returns updated head after reversing the list starting from n1

        // if(head.next==null || head==null) --. cheack "head" fisrt and then "head.next"
        if(head==null || head.next==null) return head;

        ListNode rest = reverse(head.next); //returns head of LL without first node reversed
        //head is still pointing to the node where it was initially pointing
        head.next.next = head;
        head.next = null;

        return rest;
    }

    /**
     * Q. given a LL , sort it using MERGE SORT.
     * TC:O(NLOGN)
     */
    public static ListNode mergeSortLL(ListNode head){

        if(head==null || head.next==null) return head;

        ListNode mid = getListMid(head);

        ListNode head2 = mid.next;

        mid.next = null;

        head = mergeSortLL(head); //O(N)
        head2 = mergeSortLL(head2); //O(N)

        return merge(head , head1); //tc:O(N)
    }

    /**
     * apply QUICK SORT in LL using the code for the question "partitioning a LL based on a given value". MAY COME IN CONTEST .
     */

    /**
     * Calculate the sum of OR's of every sub-array --> WILL COME IN CONTEST .
     */

    /**
     * Q. given a 2D LL . there can be unequal no. of elements in every row. all rows are sorted in asscending order.
     *    only elements of first column are connected using links. rest links are between row elements only.
     *    flatten the 2D-list into a single sorted 1D-list , all down-pointers of which point to null.
     * 
     * 
     * Ex: 3 -->8-->14 -->  null
     *     |
     *     2 -->6 --> null
     *     | 
     *     1 -->5-->7-->9 --> null
     * 
     * ans: 1-->2-->3-->5-->6-->7-->8-->9-->14-->null (all down-pointers are pointing to null)
     * 
     * class ListNode{
     *    int val;
     *    ListNode next;
     *    ListNode down;
     *    ListNode(int v){
     *       this.val = v;
     *       this.next = null;
     *       this.down = null;
     *    }
     * }
     * 
     * approach 1 : merge 2 lists at a time : TC:O(N^3)
     * 
     * approach 2 : create a single LL(n^2) then sort it using merge-sort(N^2.logN^2) : TC:O(N^2 * Log(N^2))
     * 
     * approach 3 : similar to how power function was implemented using recursion.
     */

    /**
     * Given a LL with random pointers . return a deep copy.
     * 
     * class Node{
     *    int val;
     *    Node next;
     *    Node random;
     * }
     * 
     * Ex: 1-->2-->3-->4-->5-->null . also , random: 1-->3 , 2-->1 , 3-->5 , 4-->3 , 5-->2
     */


    public static void main(String[] args){

    }
}

/**
 * for order 1 random access we need to use arrays. LLs cant be used  .
 */