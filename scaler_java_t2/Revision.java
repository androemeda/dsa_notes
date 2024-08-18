class Revision{

    public static ArrayList<Integer> solve(){

        Comparator<ListNode> cmp = (node1 , node2) -> {

            if(node1.val < node2.val){
                return -1;
            }
            if(node2.val < node1.val){
                return 1;
            }
            return 0;
        };

        PriorityQueue<ListNode> pq = new PriorityQueue<>(cmp);

        for(int i=0 ; i< a.size() ; i++){
            pq.add(a.get(i));
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();

            tail.next = curr;
            tail = curr;

            if(curr.next != null){
                pq.add(curr.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args){

    }
}