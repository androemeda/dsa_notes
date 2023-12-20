public class Node{

    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }

    /**
     * Q. given a LL and a value , insert the value at the start and return the new head .
     * TC:O(1)
     * SC:O(1)
     */
    static Node insertAtStart(Node head , int v){
        Node newNode = new Node(v);
        newNode.next = head;
        head = newNode;
        return head;
    }

    /**
     * Q. given a LL and a value , insert the value at the end and return the LL
     * TC: O(N)
     * SC: O(1)
     */
    static Node insertAtEnd(Node head , int v){

        Node newNode = new Node(v);

        if(head==null) return  newNode;

        Node currentHead = head;

        while(currentHead.next != null){
            currentHead = currentHead.next;
        }

        currentHead.next = newNode;
        return head;
    }

    /**
     * Q. given a LL and a value and a position k , insert the value at position k and return the head of the updated LL
     */
    static Node insertAtK(Node head , int k , int val){

        if(k==0) return insertAtStart(head , val);

        //it handles "insertAtEnd" already
        
        Node newNode = new Node(val);

        Node currentHead = head;

        for(int i=0 ; i<k-1 ; i++){
            currentHead = currentHead.next;
        }

        newNode.next = currentHead.next;
        currentHead.next = newNode;

        return head;
    }

    public static void main(String[] args){
        System.out.println(insertAtStart(null , 4).val);
    }
}