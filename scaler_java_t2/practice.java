/**
 * TOP VIEW OF BINARY TREE
public class Solution {
    
    public class TreeData{
        TreeNode node;
        int dist;
        
        public TreeData(TreeNode node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    
    public ArrayList<Integer> verticalT(TreeNode A){
        
        if(A==null) return new ArrayList<Integer>();
        
        int minDist = 0 ;
        int maxDist = 0 ;
        
        Queue<TreeData> q = new LinkedList<>();
        
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        TreeData rootData = new TreeData(A , 0);
        
        q.add(rootData);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0 ; i<size ; i++){
                
                TreeData curr = q.remove();
                int dist = curr.dist;
                
                minDist = Math.min(minDist , dist);
                maxDist = Math.max(maxDist , dist);
            
                if(!map.containsKey(dist)){
                map.put(dist , new ArrayList<Integer>());
                }
            
                map.get(dist).add(curr.node.val);
                
                if(curr.node.left != null){
                    TreeData l = new TreeData(curr.node.left , dist-1);
                    q.add(l);
                }
                if(curr.node.right != null){
                    TreeData r = new TreeData(curr.node.right , dist+1);
                    q.add(r);
                }
            }
        }
        
        for(int i=minDist ; i<=maxDist ; i++){
            ans.add(map.get(i).get(0));
        }
        
        return ans;
    }
    
    public ArrayList<Integer> solve(TreeNode A) {
        
        return verticalT(A);
        
    }
}
*/

/**
 * ROTATED SORTED ARRAY SEARCH.
 */

/**
 * PAINTER'S PARTITION
 * 
 public class Solution {

    public boolean check(int[] A, int noOfWorkers, long minTime) {
        int count = 1;
        int time = 0;
        for (int i = 0; i < A.length; i++) {
            time += A[i];
            if (time > minTime) {
                count++;
                time = A[i];
            }
        }
        return count <= noOfWorkers;
    }

    public long max(int[] A) {
        long ans = A[0];
        for (int i = 0; i < A.length; i++) {
            ans = Math.max(A[i], ans);
        }
        return ans;
    }

    public long sum(int[] A) {
        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = (ans % 10000003 + A[i] % 10000003) % 10000003;
        }
        // Ensure that ans is positive after the modulo operation
        return (ans + 10000003) % 10000003;
    }

    public int paint(int A, int B, int[] C) {
        long s = max(C);
        long e = sum(C);
        long ans = sum(C);
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (check(C, A, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return (int)((ans*B)%10000003);
    }
}
 */

/**
 * REVERSE A LINKED LIST
public class Solution {
    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode current = A;
        ListNode next = A.next;

        while(next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        return current;
    }
}
 */


/**
 * MERGE SORT IN LINKED LIST
 public static ListNode mergeSortLL(ListNode head){

        if(head==null || head.next==null) return head;

        ListNode mid = getListMid(head);

        ListNode head2 = mid.next;

        mid.next = null;

        head = mergeSortLL(head); //O(N)
        head2 = mergeSortLL(head2); //O(N)

        return merge(head , head1); //tc:O(N)
    } 
 */


/**
 *  SUM OF OR OF ALL SUB-ARRAYS
 public class Solution {
    public long sumOR(int[] A) {
        int n = A.length;
        long ans = 0;
        for (int j = 0; j < 30; j++) {
            int cnt = 0;
            long subb = (1l * n * (n + 1)) / 2;
            for (int i = 0; i < n; i++) {
                if ((A[i] & (1 << j)) > 0) {
                    long curr = (1l * cnt * (cnt + 1)) / 2;
                    subb -= curr;
                    cnt = 0;
                } else {
                    cnt++;
                }
            }
            long curr = (1l * cnt * (cnt + 1)) / 2;
            subb -= curr;
            ans += subb * (1l << j);
        }
        return ans;
    }
}
 */
