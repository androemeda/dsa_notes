/**
 * LINKED LISTS
 */

public class LinkedLists {

    static class Node {
        int val;
        Node next;

        public Node(int v) {
            this.val = v;
            this.next = null;
        }

        /**
         * Q. given a LL and a value , insert the value at the start and return the new head .
         */
        Node insertAtStart(Node head , int v){

            if(head == null){
                return new Node(v);
            }

            Node newNode = new Node(v);
            newNode.next = head;
            head = newNode;
            return head;

        }
    }

    public static void main(String[] args) {
        Node n1 = null;
        Node n2 = insertAtStart(n1 , 4);
    }
}
