class LinkedLists{

    /**
     * Q. given a LL find the mid element.
     */
    public static int midEl(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Q. given a LL . reverse the LL . Do not create a new LL.
     * TC:O(N)
     * SC:O(1)
     * if used recursion : SC:O(N). TRY THIS(--HW--)
     */
    public static ListNode reverse(ListNode head){

        ListNode currentNode = head;

        ListNode nextNode = head.next;

        head.next = null;

        while(nextNode != null){
            ListNode prevNode = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.next;
            currentNode.next = prevNode;
        }
        return nextNode;
    }

    public static ListNode reverseSir(ListNode head){

        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;

        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    /**
     * Q. given a LL . reverse the first k nodes of the LL.
     * Ex: LL = 0->1->2->3->4->5->6->null : k=4 : ans = ans:3->2->1->0->4->5->6->null 
     */
    public static ListNode reverseFirstK(ListNode head , int k){

        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;

        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    /**
     * Q. given a LL . reverse every sub-list of size k .
     * 
     * Ex: 1,2,3,4,5,6,7,8,9,10,11,null : k=3 : ans = 3,2,1,6,5,4,9,8,7,11,10,null
     * 
     * --HW-- : complete it without recursion als (using iterations) . also dry run the recursion.
     */
    public static ListNode reverseInKGroups(ListNode head , int k){
        //returns updated head after reversing the LL
        if(head == null || k==1) return head;

        ListNode prevNode = null , currentNode = head , nextNode = head.next;
        while(currentNode != null && k>0){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            k--;
        }       
        head.next = reverseInKGroups(nextNode , k);
        return prevNode;
    }

    /**
     * Q. given 2 LL which are sorted , merge them into a single sorted LL. solve the question "in-place"
     * Ex: A = 1,7,10,12,15,null
     *     B = 2,3,9,14,null
     *     ans = 1,2,3,7,9,10,12,14,15,null
     * SC:O(1)
     * TC:O(N+M)
     * 
     * if you want merged list in descending order ? (GOOGLE)
     */
    public static ListNode merge(ListNode h1 , ListNode h2){
        ListNode head;
        if(h1.val < h2.val){
            head = h1;
            h1 = h1.next;
        }else{
            head = h2;
            h2 = h2.next;
        }

        ListNode currentNode = head;

        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                currentNode.next = h1;
                h1 = h1.next;
                currentNode = currentNode.next;
            }else{
                currentNode.next = h2;
                h2 = h2.next;
                currentNode = currentNode.next;
            }
        }
    }

    public static void main(String[] args){

    }
}

/**
 * cases to test your code on: 1) null LL
 *                             2) LL of sizes 1/2/3 (may have to add extra if-else for these)
 *                             3) even length LL and odd length LL cases depending on question
 */